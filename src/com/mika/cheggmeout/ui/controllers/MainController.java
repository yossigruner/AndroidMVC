package com.mika.cheggmeout.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import android.os.Handler;
import android.widget.Toast;

import com.google.inject.Inject;
import com.mika.cheggmeout.configurations.CheggMeOutConfiguration;
import com.mika.cheggmeout.dtos.Caption;
import com.mika.cheggmeout.dtos.Data;
import com.mika.cheggmeout.dtos.Image;
import com.mika.cheggmeout.dtos.Result;
import com.mika.cheggmeout.dtos.StandardResolution;
import com.mika.cheggmeout.dtos.UserProfile;
import com.mika.cheggmeout.network.request.BaseRequest.IRequestResult;
import com.mika.cheggmeout.network.request.GetInstagrmPhotoRequest;
import com.mika.cheggmeout.ui.activities.ImageActivity;
import com.mika.cheggmeout.ui.controllers.interfaces.IMainController;
import com.mika.cheggmeout.ui.views.interfaces.IMainView;
import com.mika.cheggmeout.utils.IntentExtraParam;
import com.mika.cheggmeout.utils.IntentExtraParam.IntentParamType;

public class MainController extends BaseController<IMainView> implements
		IMainController, IRequestResult<Result> {

	@Inject
	private GetInstagrmPhotoRequest mGetInstagrmPhotoRequest;

	@Inject
	private CheggMeOutConfiguration mCheggMeOutConfiguration;

	@Override
	public void onCreate() {
		super.onCreate();

		mGetInstagrmPhotoRequest.setToken(mCheggMeOutConfiguration
				.getInstagramToken());
		mGetInstagrmPhotoRequest.setMaxItemPerRequest(20);
		mGetInstagrmPhotoRequest.execute(this);

	}

	@Override
	public void onSuccess(Result obj) {

		getView().updatePhotos(obj.getDataList());
	}

	@Override
	public void onNetworkIsOffline() {
		Toast.makeText(getContext(), "Network Is Offline", Toast.LENGTH_LONG)
				.show();

	}

	@Override
	public void onFailed(HttpStatus responseCode) {

		StandardResolution standardResolution = new StandardResolution();
		standardResolution
				.setUrl("http://distilleryimage3.s3.amazonaws.com/9af05e6a06e311e3b6e522000a1fd512_7.jpg");
		Image image = new Image();
		image.setStandardResolution(standardResolution);

		UserProfile profile = new UserProfile();
		profile.setUsername("yossi");
		profile.setProfilePicture("http://images.ak.instagram.com/profiles/profile_17399560_75sq_1350958494.jpg");

		Caption caption = new Caption();
		caption.setCreatedTime("yossi gruner");

		Data data = new Data();
		data.setProfile(profile);
		data.setCaption(caption);
		data.setImages(image);

		List<Data> dataList = new ArrayList<Data>();
		dataList.add(data);
		dataList.add(data);
		dataList.add(data);
		dataList.add(data);
		dataList.add(data);
		dataList.add(data);
		dataList.add(data);
		dataList.add(data);
		dataList.add(data);
		dataList.add(data);
		dataList.add(data);
		dataList.add(data);

		getView().updatePhotos(dataList);

		Toast.makeText(getContext(), "Failed to get results", Toast.LENGTH_LONG)
				.show();

	}

	@Override
	public Handler getCallbackHandler() {
		return getControllerHandler();
	}

	@Override
	public void onDataSelected(Data selcetedData) {

		ArrayList<IntentExtraParam<?>> paramsList = new ArrayList<IntentExtraParam<?>>();
		IntentExtraParam<String> extraRideId = new IntentExtraParam<String>(
				DisplayImageController.IMAGE_URL_PARAM_NAME, selcetedData.getImages()
						.getStandardResolution().getUrl(),
				IntentParamType.String);

		paramsList.add(extraRideId);
		moveToView(ImageActivity.class, paramsList);

	}

}
