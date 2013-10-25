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
public class ItemLookupSample {
	
	private static Logger LOG = Logger.getLogger(ItemLookupSample.class);
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

    /*
     * The Item ID to lookup. The value below was selected for the US locale.
     * You can choose a different value if this value does not work in the
     * locale of your choice.
     */
    private static final String ITEM_ID = "0545010225";

    public static void main(String[] args) {
        /*
         * Set up the signed requests helper 
         */
        SignedRequestsHelper helper;
        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
            LOG.error(" ",e);
            return;
        }
        
        String requestUrl = null;
        String title = null;

        /* The helper can sign requests in two forms - map form and string form */
        
        /*
         * Here is an example in map form, where the request parameters are stored in a map.
         */
        /*LOG.info("Map form example:");
        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2011-08-01");
        params.put("Operation", "ItemLookup");
        params.put("ItemId", ITEM_ID);
        params.put("ResponseGroup", "Small");
        params.put("AssociateTag", "taga");*/
        

        /*requestUrl = helper.sign(params);
        LOG.info("Signed Request is \"" + requestUrl + "\"");

        title = fetchTitle(requestUrl);
        LOG.info("Signed Title is \"" + title + "\"");
        LOG.info();*/

        /* Here is an example with string form, where the requests parameters have already been concatenated
         * into a query string. */
        LOG.info("String form example:");
        String queryString = "Service=AWSECommerceService&AssociateTag=taqa&Condition=New&IdType=ASIN&ItemId=B002DQLGHU&Operation=ItemLookup&ResponseGroup=Images%2CItemAttributes%2COffers&Version=";
        requestUrl = helper.sign(queryString);
        LOG.info("Request is \"" + requestUrl + "\"");

        title = parseXML(requestUrl);
        

    }

    /*
     * Utility function to fetch the response from the service and extract the
     * title from the XML.
     */
    private static String parseXML(String requestUrl) {
        String title = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
            
            NodeList nodeList = doc.getChildNodes();
            
            Node item = nodeList.item(0).getChildNodes().item(1).getChildNodes().item(1);
            NodeList itemNodes = item.getChildNodes();
            String detailPageURL = itemNodes.item(1).getTextContent();
            LOG.info(detailPageURL);
            String imgURL = itemNodes.item(5).getChildNodes().item(0).getTextContent();
            LOG.info(imgURL);
            
            String productTitle = itemNodes.item(7).getChildNodes().item(18).getTextContent();
            
            Node offer = itemNodes.item(8);
            NodeList offerList = offer.getChildNodes();
            
            String price = offerList.item(0).getChildNodes().item(2).getTextContent();
            LOG.info(price);
            
            
        } catch (Exception e) {
        	LOG.error(" ",e);
            throw new RuntimeException(e);
        }
        return title;
    }
    
    public static void recurse(NodeList root){
    	LOG.info(root.getLength());
    	
    	for(int i=0; i<root.getLength() ; i++){
    		LOG.info(root.item(i).getNodeName() + "-->" +root.item(i).getTextContent() + ":-->" + root.item(i).getNodeType());
    		recurse(root.item(i).getChildNodes());
    	}
    	
    }
    
    

}
