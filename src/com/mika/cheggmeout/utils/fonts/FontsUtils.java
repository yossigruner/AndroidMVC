
package com.mika.cheggmeout.utils.fonts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class fontsUtils.
 */
public class FontsUtils {

	private static Map<String, Typeface> sTypefacesList = new HashMap<String, Typeface>();

	/**
	 * Apply font to text view.
	 * 
	 * @param context the context
	 * @param textView the text view
	 * @param font the font
	 */
	public static void applyFontToTextView(Context context, TextView textView, CheggMeOutFont font) {

		// Loading Font Face
		Typeface tf = sTypefacesList.get(font.getFontAssetPath());
		if (tf == null) {
			tf = Typeface.createFromAsset(context.getAssets(), font.getFontAssetPath());
			sTypefacesList.put(font.getFontAssetPath(), tf);
		}

		// Applying font
		textView.setTypeface(tf);

	}

	/**
	 * Apply font to text view.
	 * 
	 * @param activity the activity
	 * @param id the id
	 * @param font the font
	 */
	public static void applyFontToTextView(Activity activity, int id, CheggMeOutFont font) {

		TextView v = (TextView) activity.findViewById(id);

		Typeface tf = sTypefacesList.get(font.getFontAssetPath());
		if (tf == null) {
			tf = Typeface.createFromAsset(activity.getAssets(), font.getFontAssetPath());
			sTypefacesList.put(font.getFontAssetPath(), tf);
		}

		// Applying font
		v.setTypeface(tf);

	}

	
	
	
	
	
	
	
	
}
