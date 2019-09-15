package com.jd.mvvmexample.repository;

import android.util.Log;
import com.jd.mvvmexample.repository.retrofit.model.Image;
import com.jd.mvvmexample.repository.retrofit.model.ParentResponse;
import java.util.List;

public class Repository implements DataContract {

    private static Repository INSTANCE = null;

    private DataContract dataContract;

    public Repository(DataContract dataContract) {
        this.dataContract=dataContract;
    }

    public static Repository getInstance(DataContract socialWallRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(socialWallRemoteDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getPSdetails(final callBack callBack) {

        dataContract.getPSdetails(new callBack() {
            @Override
            public void success(ParentResponse parentResponse) {
                callBack.success(parentResponse);
            }

            @Override
            public void failure(Object errorObject) {
                callBack.failure(errorObject);

            }
        });

    }

    @Override
    public void getImages(final ImageCallBack callBack) {
        dataContract.getImages(new ImageCallBack() {
            @Override
            public void success(List<Image> listLiveData) {
                Log.d("data1remote","dataremtoe");
                callBack.success(listLiveData);
            }

            @Override
            public void failure(Object errorObject) {

            }
        });
    }
}
