package com.jd.mvvmexample.repository;

import com.jd.mvvmexample.repository.retrofit.model.Image;
import com.jd.mvvmexample.repository.retrofit.model.ParentResponse;
import java.util.List;

public interface DataContract {

     void getPSdetails(callBack callBack);

     void getImages(ImageCallBack imageCallBack);

     interface callBack
     {
          void success(ParentResponse parentResponse);
          void failure(Object errorObject);
     }

     interface ImageCallBack{
          void success(List<Image> listLiveData);
          void failure(Object errorObject);
     }
}
