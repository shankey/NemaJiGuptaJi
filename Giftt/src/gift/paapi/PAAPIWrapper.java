/**********************************************************************************************
 * Copyright 2009 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file 
 * except in compliance with the License. A copy of the License is located at
 *
 *       http://aws.amazon.com/apache2.0/
 *
 * or in the "LICENSE.txt" file accompanying this file. This file is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under the License. 
 *
 * ********************************************************************************************
 *
 *  Amazon Product Advertising API
 *  Signed Requests Sample Code
 *
 *  API Version: 2009-03-31
 *
 */

package gift.paapi;

import gift.bao.CategoryDetailBAO;
import gift.model.GiftAsinDetail;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * This class shows how to make a simple authenticated ItemLookup call to the
 * Amazon Product Advertising API.
 * 
 * See the README.html that came with this sample for instructions on
 * configuring and running the sample.
 */
public class PAAPIWrapper {
	
	private static Logger LOG = Logger.getLogger(PAAPIWrapper.class);
    /*
     * Your AWS Access Key ID, as taken from the AWS Your Account page.
     */
    private static final String AWS_ACCESS_KEY_ID = "AKIAJDVM2PUZ2TV4ENLQ";

    /*
     * Your AWS Secret Key corresponding to the above ID, as taken from the AWS
     * Your Account page.
     */
    private static final String AWS_SECRET_KEY = "6Cly61C1FEKlvAKbr+4P5NiEIiok/Nl7wze6tFaL";

    /*
     * Use one of the following end-points, according to the region you are
     * interested in:
     * 
     *      US: ecs.amazonaws.com 
     *      CA: ecs.amazonaws.ca 
     *      UK: ecs.amazonaws.co.uk 
     *      DE: ecs.amazonaws.de 
     *      FR: ecs.amazonaws.fr 
     *      JP: ecs.amazonaws.jp
     * 
     */
    private static final String ENDPOINT = "ecs.amazonaws.com";
    
    private static final PAAPIWrapper WRAPPER = new PAAPIWrapper();

    /*
     * The Item ID to lookup. The value below was selected for the US locale.
     * You can choose a different value if this value does not work in the
     * locale of your choice.
     */
    private static final String ITEM_ID = "0545010225";
    
    private SignedRequestsHelper helper= null;
    
    public static PAAPIWrapper getPAAPIWrapper(){
    	return WRAPPER;
    }

    public PAAPIWrapper() {
    	
        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
            LOG.error(" ",e);
            return;
        }

        /* The helper can sign requests in two forms - map form and string form */
        
        

	}

	public static void main(String[] args) {
        new PAAPIWrapper().callPAAPI("B00D9EPI38");
    }
	
	public GiftAsinDetail callPAAPI(String asin){
		
		String queryString = "Service=AWSECommerceService&AssociateTag=taqa&Condition=New&IdType=ASIN&ItemId="+asin+"&Operation=ItemLookup&ResponseGroup=Images%2CItemAttributes%2COffers&Version=";
		String requestUrl = helper.sign(queryString);
		LOG.info("Request is \"" + requestUrl + "\"");
		
		GiftAsinDetail asinDetail = new GiftAsinDetail();
		parseXML(asin, requestUrl, asinDetail);
		LOG.info("ASIN details are : "+asinDetail);
		return asinDetail;
	}

    /*
     * Utility function to fetch the response from the service and extract the
     * title from the XML.
     */
    private GiftAsinDetail parseXML(String asin, String requestUrl, GiftAsinDetail asinDetail) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
            
            NodeList nodeList = doc.getChildNodes();
            
            Node root = getNode("ItemLookupResponse", nodeList);
            Node items = getNode("Items", root.getChildNodes());
            Node item = getNode("Item", items.getChildNodes());
            Node detailPageUrl = getNode("DetailPageURL", item.getChildNodes());
            Node largeImage = getNode("LargeImage", item.getChildNodes());
            Node url = getNode("URL", largeImage.getChildNodes());
            Node itemAttributes = getNode("ItemAttributes", item.getChildNodes());
            Node title = getNode("Title", itemAttributes.getChildNodes());
            Node offerSummary = getNode("OfferSummary", item.getChildNodes());
            Node lowestNewPrice = getNode("LowestNewPrice", offerSummary.getChildNodes());
            Node formattedPrice = getNode("FormattedPrice", lowestNewPrice.getChildNodes());
            
            asinDetail.setAsin(asin);
            asinDetail.setDetailPage(detailPageUrl.getTextContent());
            asinDetail.setImage(url.getTextContent());
            asinDetail.setPrice(Float.parseFloat(formattedPrice.getTextContent().substring(1)));
            asinDetail.setTitle(title.getTextContent());
            
            
            /*Node item = nodeList.item(0).getChildNodes().item(1).getChildNodes().item(1);
            NodeList itemNodes = item.getChildNodes();
            String detailPageURL = itemNodes.item(1).getTextContent();
            LOG.info(detailPageURL);
            asinDetail.setAsin(asin);
            asinDetail.setDetailPage(detailPageURL);
            String imgURL = itemNodes.item(5).getChildNodes().item(0).getTextContent();
            LOG.info(imgURL);
            asinDetail.setImage(imgURL);
            String productTitle = itemNodes.item(7).getChildNodes().item(18).getTextContent();
            asinDetail.setTitle(productTitle);
            Node offer = itemNodes.item(8);
            NodeList offerList = offer.getChildNodes();
            
            String price = offerList.item(0).getChildNodes().item(2).getTextContent();
            LOG.info(price);
            asinDetail.setPrice(Float.parseFloat(price.substring(1)));*/
          
            
        } catch (Exception e) {
        	LOG.error(" ",e);
            //throw new RuntimeException(e);
        }
        return asinDetail;
    }
    
    public Node getNode(String nodeName, NodeList nodeList){
    	for(int i=0; i<nodeList.getLength(); i++){
    		String node = nodeList.item(i).getNodeName();
    		if(node.equals(nodeName)){
    			LOG.info(node);
    			return nodeList.item(i);
    		}
    	}
    	return null;
    }
    
    public static void recurse(NodeList root){
    	LOG.info(root.getLength());
    	
    	for(int i=0; i<root.getLength() ; i++){
    		LOG.info(root.item(i).getNodeName() + "-->" +root.item(i).getTextContent() + ":-->" + root.item(i).getNodeType());
    		recurse(root.item(i).getChildNodes());
    	}
    	
    }
    
    

}
