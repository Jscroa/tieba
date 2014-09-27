package sss.yyao.tieba.action.account;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.util.ImageUtil;

public class CreateImageAction extends BaseAction {
	private InputStream imageStream;

	public InputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

	public String execute(){
		Map<String, BufferedImage> map = ImageUtil.createImage();
		String code = map.keySet().iterator().next();
		session.put("imageCode", code);
		BufferedImage image = map.get(code);
		try {
			imageStream = ImageUtil.getInputStream(image);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

}
