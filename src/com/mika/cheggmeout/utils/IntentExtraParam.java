
package com.mika.cheggmeout.utils;

/**
 * The Class IntentExtraParam.
 * 
 * @param <T> the generic type
 */
public class IntentExtraParam<T> {

	/**
	 * The Enum IntentParamType.
	 */
	public enum IntentParamType {

		/** The Int. */
		Int,

		/** The Parcelable. */
		Parcelable,

		/** The String. */
		String,

		/** The Boolean. */
		Boolean,

		/** The Long. */
		Long,

		/** The Double. */
		Double,

		/** The Float. */
		Float
	}

	/** The m param name. */
	private String mParamName;

	/** The m param value. */
	private T mParamValue;

	/** The m intent param type. */
	private IntentParamType mIntentParamType;

	/**
	 * Instantiates a new intent extra param.
	 * 
	 * @param paramName the param name
	 * @param paramValue the param value
	 * @param intentParamType the intent param type
	 */
	public IntentExtraParam(String paramName, T paramValue, IntentParamType intentParamType) {
		super();
		mParamName = paramName;
		mParamValue = paramValue;
		mIntentParamType = intentParamType;
	}

	/**
	 * Gets the param name.
	 * 
	 * @return the param name
	 */
	public String getParamName() {
		return mParamName;
	}

	/**
	 * Gets the param value.
	 * 
	 * @return the param value
	 */
	public T getParamValue() {
		return mParamValue;
	}

	/**
	 * Gets the intent param type.
	 * 
	 * @return the intent param type
	 */
	public IntentParamType getIntentParamType() {
		return mIntentParamType;
	}

}
