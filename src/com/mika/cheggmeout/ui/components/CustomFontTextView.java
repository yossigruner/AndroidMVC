package com.mika.cheggmeout.ui.components;

import roboguice.util.Ln;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import com.mika.cheggmeout.R;
import com.mika.cheggmeout.utils.fonts.CheggMeOutFont;
import com.mika.cheggmeout.utils.fonts.FontsUtils;

public class CustomFontTextView extends TextView {

	public CustomFontTextView(Context context, AttributeSet attrs) {
		this(context, attrs, null);

	}

	public CustomFontTextView(Context context, AttributeSet attrs,
			CheggMeOutFont font) {
		super(context, attrs);

		TypedArray typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.CustomFontTextView);
		try {
			CharSequence fontType = typedArray
					.getString(R.styleable.CustomFontTextView_FontFamily);

			if (TextUtils.isEmpty(fontType)) {
				Ln.e("Font Type can't be null or empty");
				return;
			}

			CheggMeOutFont selectedFont = CheggMeOutFont.fromString(fontType.toString());
			if (selectedFont == null) {
				selectedFont = CheggMeOutFont.valueOf(fontType.toString());
			}

			FontsUtils.applyFontToTextView(context, this, selectedFont);
		} finally {
			typedArray.recycle();
		}
	}
}
