package com.sist.xml;

import javax.xml.bind.annotation.XmlRootElement;
/*
 * 	Binding 바인딩
 *  클래스 객체 <=====> XML 태그 매칭 (빅데이터에서 많이 사용=AI)
 *  		  bind
 *   <rss>						태그와 태그 사이에 태그 => 클래스 => Rss
 *     <channel>										 => Channel
 *       <item>											 => Item
 *         <title>aaa</title>	태그와 태그사이에 값 => 변수	 => String
 *         <author>bbb</author> 태그와 태그사이에 값 => 변수	 => String
 *       </item>
 *       <item>
 *         <title>aaa</title>
 *         <author>bbb</author>
 *       </item>
 *     </channel>
 *   </rss>
 *   
 *   XML태그 ==> 클래스  : 언마샬
 *   클래스 ==> XML파일  : 미샬
 *   ========================== OXM (Object Xml Maker) => 라이브러리 : jaxb.jar (Java Annotation(?) Xml Binding) ==> 챗봇
 */
@XmlRootElement
public class Rss {
	private Channel channel=new Channel();

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
}
