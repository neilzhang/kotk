/**
 * 
 */
package org.hb.kotk.core.util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * @author neil
 * 
 */
public final class XmlReader
{
	private XmlReader()
	{
	}

	public static Document getXml(String fileName) throws DocumentException
	{
		if (fileName.trim().isEmpty())
		{
			return null;
		}
		File inputXml = new File(fileName.trim());
		SAXReader saxReader = new SAXReader();
		return saxReader.read(inputXml);
	}
}
