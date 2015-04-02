package com.mika.cheggmeout.utils.fonts;

/**
 * The Enum Font.
 */
public enum CheggMeOutFont {

	Roboto_Bold("fonts/Roboto-Bold.ttf"),

	Roboto_Italic("fonts/Roboto-Italic.ttf"),

	Roboto_Regular("fonts/Roboto-Regular.ttf");

	/** The Font assets path. */
	private String mFontAssetPath;

	/**
	 * Instantiates a new font.
	 * 
	 * @param fontAssettPath
	 *            the font asset path
	 */
	CheggMeOutFont(String fontAssettPath) {
		this.mFontAssetPath = fontAssettPath;
	}

	/**
	 * Gets the font asset path.
	 * 
	 * @return the font asset path
	 */
	public String getFontAssetPath() {
		return this.mFontAssetPath;
	}

	/**
	 * From string.
	 * 
	 * @param text
	 *            the text
	 * @return the font
	 */
	public static CheggMeOutFont fromString(String text) {
		if (text != null) {
			for (CheggMeOutFont font : CheggMeOutFont.values()) {
				if (text.equalsIgnoreCase(font.mFontAssetPath)) {
					return font;
				}
			}
		}
		return null;
	}

}
