package com.fusionCharts.common.style;

public class FontStyle extends Style {
	
	private String font;
	private String size;
	private String color;
	private String bold;
	private String italic;
	private String underline;
	private String bgColor;
	private String borderColor;
	private String isHTML;
	private String leftMargin;
	private String letterSpacing;
	
	public FontStyle(String name) {
		this.type = "font";
		this.name = name;
	}
	
	public FontStyle(String name, String size, String color, String bold) {
		this.type = "font";
		this.name = name;
		this.size = size;
		this.color = color;
		this.bold = bold;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBold() {
		return bold;
	}

	public void setBold(String bold) {
		this.bold = bold;
	}

	public String getItalic() {
		return italic;
	}

	public void setItalic(String italic) {
		this.italic = italic;
	}

	public String getUnderline() {
		return underline;
	}

	public void setUnderline(String underline) {
		this.underline = underline;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public String getIsHTML() {
		return isHTML;
	}

	public void setIsHTML(String isHTML) {
		this.isHTML = isHTML;
	}

	public String getLeftMargin() {
		return leftMargin;
	}

	public void setLeftMargin(String leftMargin) {
		this.leftMargin = leftMargin;
	}

	public String getLetterSpacing() {
		return letterSpacing;
	}

	public void setLetterSpacing(String letterSpacing) {
		this.letterSpacing = letterSpacing;
	}
	
}
