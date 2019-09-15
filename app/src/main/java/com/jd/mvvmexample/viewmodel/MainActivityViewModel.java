package com.jd.mvvmexample.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import com.jd.mvvmexample.repository.DataContract.ImageCallBack;
import com.jd.mvvmexample.repository.RemoteDataSource;
import com.jd.mvvmexample.repository.Repository;
import com.jd.mvvmexample.repository.retrofit.model.Image;
import java.util.List;

public class MainActivityViewModel extends android.arch.lifecycle.ViewModel {


    private MutableLiveData<List<Image>> listMutableLiveData;
    private Repository repository;

  public MutableLiveData<List<Image>> getImages() {
            if(listMutableLiveData==null) {
                listMutableLiveData = new MutableLiveData<List<Image>>();
                Repository.getInstance(RemoteDataSource.getInstance())
                    .getImages(new ImageCallBack() {
                        @Override
                        public void success(List<Image> listLiveData) {
                            listMutableLiveData.setValue(listLiveData);
                        }

                        @Override
                        public void failure(Object errorObject) {

                        }
                    });
            }
        return listMutableLiveData;
    }
}
