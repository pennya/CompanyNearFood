package com.kh.companyfood.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.kh.companyfood.R;
import com.kh.companyfood.define.Define;
import com.kh.companyfood.vo.Map;
import com.kh.companyfood.vo.RestaurantDetail;
import com.nhn.android.maps.NMapContext;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

import java.util.ArrayList;

/**
 * Created by KJH on 2017-08-22.
 */

public class NaverMapFragment extends Fragment {
    private NMapContext mMapContext;
    private NMapView mMapView;
    private NMapController mMapController;
    private NMapViewerResourceProvider mMapViewerResourceProvider;
    private NMapOverlayManager mOverlayManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_naver_map, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapContext =  new NMapContext(super.getActivity());
        mMapContext.onCreate();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMapView = (NMapView)getView().findViewById(R.id.mapView);
        mMapView.setClientId(Define.CLIENT_ID);
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();
        mMapContext.setupMapView(mMapView);

        mMapView.setOnMapStateChangeListener(onMapStateChangeListener);
        mMapView.setOnMapViewTouchEventListener(onMapViewTouchEventListener);
        mMapView.setOnMapViewDelegate(onMapViewDelegate);

        mMapController = mMapView.getMapController();
        NMapView.LayoutParams lp = new NMapView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, NMapView.LayoutParams.BOTTOM_RIGHT);
        mMapView.setBuiltInZoomControls(true, lp);
        mMapView.setScalingFactor(2.f);

        mMapViewerResourceProvider = new NMapViewerResourceProvider(getActivity());
        mOverlayManager = new NMapOverlayManager(getActivity(), mMapView, mMapViewerResourceProvider);
    }

    @Override
    public void onStart() {
        super.onStart();
        mMapContext.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapContext.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapContext.onPause();
    }

    @Override
    public void onStop() {
        mMapContext.onStop();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        mMapContext.onDestroy();
        super.onDestroy();
    }

    private final NMapView.OnMapStateChangeListener onMapStateChangeListener
            = new NMapView.OnMapStateChangeListener() {
        @Override
        public void onMapInitHandler(NMapView nMapView, NMapError nMapError) {
            ArrayList<RestaurantDetail> restaurantDetailList = (ArrayList<RestaurantDetail>)getArguments().get("MapData");
            mMapController.setMapCenter(new NGeoPoint(
                    Double.parseDouble(restaurantDetailList.get(0).getMap()[0].getLatitude()),
                    Double.parseDouble(restaurantDetailList.get(0).getMap()[0].getLongitude())),
                    11);

            int markerId = NMapPOIflagType.PIN;
            NMapPOIdata poiData = new NMapPOIdata(2, mMapViewerResourceProvider);
            poiData.beginPOIdata(1);
            poiData.addPOIitem(
                    Double.parseDouble(restaurantDetailList.get(0).getMap()[0].getLatitude()),
                    Double.parseDouble(restaurantDetailList.get(0).getMap()[0].getLongitude()),
                    restaurantDetailList.get(0).getRestaurant()[0].getName(),
                    markerId,
                    0);
            poiData.endPOIdata();
            NMapPOIdataOverlay poiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
            poiDataOverlay.showAllPOIdata(0);
        }

        @Override
        public void onMapCenterChange(NMapView nMapView, NGeoPoint nGeoPoint) {

        }

        @Override
        public void onMapCenterChangeFine(NMapView nMapView) {

        }

        @Override
        public void onZoomLevelChange(NMapView nMapView, int i) {

        }

        @Override
        public void onAnimationStateChange(NMapView nMapView, int i, int i1) {

        }
    };

    private final NMapView.OnMapViewTouchEventListener onMapViewTouchEventListener
            = new NMapView.OnMapViewTouchEventListener() {
        @Override
        public void onLongPress(NMapView nMapView, MotionEvent motionEvent) {

        }

        @Override
        public void onLongPressCanceled(NMapView nMapView) {

        }

        @Override
        public void onTouchDown(NMapView nMapView, MotionEvent motionEvent) {

        }

        @Override
        public void onTouchUp(NMapView nMapView, MotionEvent motionEvent) {

        }

        @Override
        public void onScroll(NMapView nMapView, MotionEvent motionEvent, MotionEvent motionEvent1) {

        }

        @Override
        public void onSingleTapUp(NMapView nMapView, MotionEvent motionEvent) {

        }
    };

    private final NMapView.OnMapViewDelegate onMapViewDelegate
            = new NMapView.OnMapViewDelegate() {
        @Override
        public boolean isLocationTracking() {
            return false;
        }
    };
}
