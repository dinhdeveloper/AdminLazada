package com.dinh.thuhuyen.api;

import com.dinh.thuhuyen.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("product/list")
    Call<List<ProductModel>> getAllProductModel();

    @POST("product/")
    Call<ProductModel> updateProductModel(@Body ProductModel product);

//
//    @GET("product/list")
//    Call<List<Product>> getAllProduct();
//
//    @GET("/product/search={search}")
//    Call<List<Product>> searchProduct(@Path("search") String search);
//
////    @POST("product/list")
////    Call<ArrayList<Product>> getProductLists(@Body PagingProduct pagingProduct);
//
//    @GET("product/cate={id}")
//    Call<ArrayList<Product>> getProductByCateId(@Path("id") int id);
//
//    @GET("product/homepage")
//    Call<ArrayList<ListRVProduct>> getProduct(@Query("page") int page, @Query("size") int size);
//
//    @GET("product/pageproduct")
//    Call<ArrayList<Product>> getPageProduct(@Query("page") int page, @Query("size") int size);
//
//    @POST("customer")
//    Call<Customer> addCustomer(@Body Customer customer);
//
//    @POST("customer/check")
//    Call<Customer> checkLogin(@Body Customer phoneNumber);
//
//    @GET("customer/phone/{phone}")
//    Call<Customer> getCustomerByPhone(@Path("phone") String phone);
//    //@GET("product/homepage")
//    //Call<ArrayList<ListRVProduct>> getProduct(@Query("page") int page, @Query("size") int size);
//
//    @GET("productImage/pro/{id}")
//    Call<ArrayList<ProductImage>> getAllProductImageByProId(@Path("id") int id);
//
//    @GET("province/list")
//    Call<ArrayList<Province>> getAllProvince();
//
//    @GET("district/list")
//    Call<ArrayList<District>> getAllDistrict();
//    @GET("district/{id}")
//    Call<ArrayList<District>> getDistrictById(@Path("id") int id);
//    @GET("district/pr={id}")
//    Call<ArrayList<District>> getDistrictByProId(@Path("id") int id);
//
//    @GET("village/id={id}")
//    Call<ArrayList<Village>> getVillageById(@Path("id") int id);
//    @GET("village/ds={id}")
//    Call<ArrayList<Village>> getVillageByDsId(@Path("id") int id);
//
//    @POST("address")
//    Call<Address> addAddress(@Body Address address);
//    @GET("address/cus={id}")
//    Call<ArrayList<Address>> getAddressByCus(@Path("id") int id);
//
//    @GET("address/status/{id}")
//    Call<ArrayList<Address>> getStatusTrue(@Path("id") int id);
//
//    @GET("paymentform/list")
//    Call<ArrayList<PaymentForm>> getAllPaymentForm();
//
//    @GET("orders/cus/{id}")
//    Call<ArrayList<Order>> getOrderByCus(@Path("id") int id);
//    @POST("orders")
//    Call<Order> addOrder(@Body Order order);
//
//    @POST("orderdetail")
//    Call<OrderDetail> addOrderDetail(@Body OrderDetail orderDetail);
//
//    @GET("/orderdetail/order/{id}")
//    Call<ArrayList<OrderDetail>> getAllOrderdetailByOrderId(@Path("id") int id);
//
//    @GET("/orderstatus/{id}")
//    Call<OrderStatus> getOrderStatusById(@Path("id") int id);
//
//    @GET("hotkey/list")
//    Call<List<HotKeySearch>> getAllHotKey();
}
