package utilities;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ConfigReader {

    private static String baseUrl;
    private static String registerUrl;
    private static final String CONFIG_FILE_PATH = "src/test/resources/config/config.xml";

    static {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(CONFIG_FILE_PATH);
            Element root = document.getDocumentElement();

            baseUrl = getTextContent(root, "baseUrl");
            registerUrl = getTextContent(root, "registerUrl");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTextContent(Element parent, String tagName) {
        NodeList nodeList = parent.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getRegisterUrl() {
        return registerUrl;
    }


}
