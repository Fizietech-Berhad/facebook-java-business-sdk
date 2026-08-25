/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class ProductCatalogHotelsItemGet extends APINode {
  @SerializedName("additional_image_urls")
  private List<String> mAdditionalImageUrls = null;
  @SerializedName("address")
  private String mAddress = null;
  @SerializedName("applink_android_app_name")
  private String mApplinkAndroidAppName = null;
  @SerializedName("applink_android_class")
  private String mApplinkAndroidClass = null;
  @SerializedName("applink_android_package")
  private String mApplinkAndroidPackage = null;
  @SerializedName("applink_android_url")
  private String mApplinkAndroidUrl = null;
  @SerializedName("applink_ios_app_name")
  private String mApplinkIosAppName = null;
  @SerializedName("applink_ios_app_store_id")
  private Long mApplinkIosAppStoreId = null;
  @SerializedName("applink_ios_url")
  private String mApplinkIosUrl = null;
  @SerializedName("applinks")
  private Object mApplinks = null;
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("custom_label_0")
  private String mCustomLabel0 = null;
  @SerializedName("custom_label_1")
  private String mCustomLabel1 = null;
  @SerializedName("custom_label_2")
  private String mCustomLabel2 = null;
  @SerializedName("custom_label_3")
  private String mCustomLabel3 = null;
  @SerializedName("custom_label_4")
  private String mCustomLabel4 = null;
  @SerializedName("custom_number_0")
  private Long mCustomNumber0 = null;
  @SerializedName("custom_number_1")
  private Long mCustomNumber1 = null;
  @SerializedName("custom_number_2")
  private Long mCustomNumber2 = null;
  @SerializedName("custom_number_3")
  private Long mCustomNumber3 = null;
  @SerializedName("custom_number_4")
  private Long mCustomNumber4 = null;
  @SerializedName("da_display_preview_url")
  private String mDaDisplayPreviewUrl = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("guest_ratings")
  private String mGuestRatings = null;
  @SerializedName("hotel_id")
  private String mHotelId = null;
  @SerializedName("id")
  private Long mId = null;
  @SerializedName("image_fetch_status")
  private String mImageFetchStatus = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("lowest_base_price")
  private String mLowestBasePrice = null;
  @SerializedName("loyalty_program")
  private String mLoyaltyProgram = null;
  @SerializedName("margin_level")
  private Long mMarginLevel = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("number_of_rooms")
  private Long mNumberOfRooms = null;
  @SerializedName("phone")
  private String mPhone = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("product_priority_0")
  private Double mProductPriority0 = null;
  @SerializedName("product_priority_1")
  private Double mProductPriority1 = null;
  @SerializedName("product_priority_2")
  private Double mProductPriority2 = null;
  @SerializedName("product_priority_3")
  private Double mProductPriority3 = null;
  @SerializedName("product_priority_4")
  private Double mProductPriority4 = null;
  @SerializedName("retailer_id")
  private String mRetailerId = null;
  @SerializedName("sale_price")
  private String mSalePrice = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("star_rating")
  private Double mStarRating = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("video_urls")
  private List<String> mVideoUrls = null;
  @SerializedName("videos_metadata")
  private Object mVideosMetadata = null;
  @SerializedName("visibility")
  private String mVisibility = null;
  protected static Gson gson = null;

  public ProductCatalogHotelsItemGet() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductCatalogHotelsItemGet loadJSON(String json, APIContext context, String header) {
    ProductCatalogHotelsItemGet productCatalogHotelsItemGet = getGson().fromJson(json, ProductCatalogHotelsItemGet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productCatalogHotelsItemGet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productCatalogHotelsItemGet.context = context;
    productCatalogHotelsItemGet.rawValue = json;
    productCatalogHotelsItemGet.header = header;
    return productCatalogHotelsItemGet;
  }

  public static APINodeList<ProductCatalogHotelsItemGet> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductCatalogHotelsItemGet> productCatalogHotelsItemGets = new APINodeList<ProductCatalogHotelsItemGet>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          productCatalogHotelsItemGets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productCatalogHotelsItemGets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productCatalogHotelsItemGets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productCatalogHotelsItemGets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productCatalogHotelsItemGets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productCatalogHotelsItemGets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  productCatalogHotelsItemGets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productCatalogHotelsItemGets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productCatalogHotelsItemGets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productCatalogHotelsItemGets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productCatalogHotelsItemGets;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              productCatalogHotelsItemGets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productCatalogHotelsItemGets;
          }

          // Sixth, check if it's pure JsonObject
          productCatalogHotelsItemGets.clear();
          productCatalogHotelsItemGets.add(loadJSON(json, context, header));
          return productCatalogHotelsItemGets;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public List<String> getFieldAdditionalImageUrls() {
    return mAdditionalImageUrls;
  }

  public ProductCatalogHotelsItemGet setFieldAdditionalImageUrls(List<String> value) {
    this.mAdditionalImageUrls = value;
    return this;
  }

  public String getFieldAddress() {
    return mAddress;
  }

  public ProductCatalogHotelsItemGet setFieldAddress(String value) {
    this.mAddress = value;
    return this;
  }

  public String getFieldApplinkAndroidAppName() {
    return mApplinkAndroidAppName;
  }

  public ProductCatalogHotelsItemGet setFieldApplinkAndroidAppName(String value) {
    this.mApplinkAndroidAppName = value;
    return this;
  }

  public String getFieldApplinkAndroidClass() {
    return mApplinkAndroidClass;
  }

  public ProductCatalogHotelsItemGet setFieldApplinkAndroidClass(String value) {
    this.mApplinkAndroidClass = value;
    return this;
  }

  public String getFieldApplinkAndroidPackage() {
    return mApplinkAndroidPackage;
  }

  public ProductCatalogHotelsItemGet setFieldApplinkAndroidPackage(String value) {
    this.mApplinkAndroidPackage = value;
    return this;
  }

  public String getFieldApplinkAndroidUrl() {
    return mApplinkAndroidUrl;
  }

  public ProductCatalogHotelsItemGet setFieldApplinkAndroidUrl(String value) {
    this.mApplinkAndroidUrl = value;
    return this;
  }

  public String getFieldApplinkIosAppName() {
    return mApplinkIosAppName;
  }

  public ProductCatalogHotelsItemGet setFieldApplinkIosAppName(String value) {
    this.mApplinkIosAppName = value;
    return this;
  }

  public Long getFieldApplinkIosAppStoreId() {
    return mApplinkIosAppStoreId;
  }

  public ProductCatalogHotelsItemGet setFieldApplinkIosAppStoreId(Long value) {
    this.mApplinkIosAppStoreId = value;
    return this;
  }

  public String getFieldApplinkIosUrl() {
    return mApplinkIosUrl;
  }

  public ProductCatalogHotelsItemGet setFieldApplinkIosUrl(String value) {
    this.mApplinkIosUrl = value;
    return this;
  }

  public Object getFieldApplinks() {
    return mApplinks;
  }

  public ProductCatalogHotelsItemGet setFieldApplinks(Object value) {
    this.mApplinks = value;
    return this;
  }

  public String getFieldBrand() {
    return mBrand;
  }

  public ProductCatalogHotelsItemGet setFieldBrand(String value) {
    this.mBrand = value;
    return this;
  }

  public String getFieldCategory() {
    return mCategory;
  }

  public ProductCatalogHotelsItemGet setFieldCategory(String value) {
    this.mCategory = value;
    return this;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public ProductCatalogHotelsItemGet setFieldCurrency(String value) {
    this.mCurrency = value;
    return this;
  }

  public String getFieldCustomLabel0() {
    return mCustomLabel0;
  }

  public ProductCatalogHotelsItemGet setFieldCustomLabel0(String value) {
    this.mCustomLabel0 = value;
    return this;
  }

  public String getFieldCustomLabel1() {
    return mCustomLabel1;
  }

  public ProductCatalogHotelsItemGet setFieldCustomLabel1(String value) {
    this.mCustomLabel1 = value;
    return this;
  }

  public String getFieldCustomLabel2() {
    return mCustomLabel2;
  }

  public ProductCatalogHotelsItemGet setFieldCustomLabel2(String value) {
    this.mCustomLabel2 = value;
    return this;
  }

  public String getFieldCustomLabel3() {
    return mCustomLabel3;
  }

  public ProductCatalogHotelsItemGet setFieldCustomLabel3(String value) {
    this.mCustomLabel3 = value;
    return this;
  }

  public String getFieldCustomLabel4() {
    return mCustomLabel4;
  }

  public ProductCatalogHotelsItemGet setFieldCustomLabel4(String value) {
    this.mCustomLabel4 = value;
    return this;
  }

  public Long getFieldCustomNumber0() {
    return mCustomNumber0;
  }

  public ProductCatalogHotelsItemGet setFieldCustomNumber0(Long value) {
    this.mCustomNumber0 = value;
    return this;
  }

  public Long getFieldCustomNumber1() {
    return mCustomNumber1;
  }

  public ProductCatalogHotelsItemGet setFieldCustomNumber1(Long value) {
    this.mCustomNumber1 = value;
    return this;
  }

  public Long getFieldCustomNumber2() {
    return mCustomNumber2;
  }

  public ProductCatalogHotelsItemGet setFieldCustomNumber2(Long value) {
    this.mCustomNumber2 = value;
    return this;
  }

  public Long getFieldCustomNumber3() {
    return mCustomNumber3;
  }

  public ProductCatalogHotelsItemGet setFieldCustomNumber3(Long value) {
    this.mCustomNumber3 = value;
    return this;
  }

  public Long getFieldCustomNumber4() {
    return mCustomNumber4;
  }

  public ProductCatalogHotelsItemGet setFieldCustomNumber4(Long value) {
    this.mCustomNumber4 = value;
    return this;
  }

  public String getFieldDaDisplayPreviewUrl() {
    return mDaDisplayPreviewUrl;
  }

  public ProductCatalogHotelsItemGet setFieldDaDisplayPreviewUrl(String value) {
    this.mDaDisplayPreviewUrl = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public ProductCatalogHotelsItemGet setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldGuestRatings() {
    return mGuestRatings;
  }

  public ProductCatalogHotelsItemGet setFieldGuestRatings(String value) {
    this.mGuestRatings = value;
    return this;
  }

  public String getFieldHotelId() {
    return mHotelId;
  }

  public ProductCatalogHotelsItemGet setFieldHotelId(String value) {
    this.mHotelId = value;
    return this;
  }

  public Long getFieldId() {
    return mId;
  }

  public ProductCatalogHotelsItemGet setFieldId(Long value) {
    this.mId = value;
    return this;
  }

  public String getFieldImageFetchStatus() {
    return mImageFetchStatus;
  }

  public ProductCatalogHotelsItemGet setFieldImageFetchStatus(String value) {
    this.mImageFetchStatus = value;
    return this;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public ProductCatalogHotelsItemGet setFieldImageUrl(String value) {
    this.mImageUrl = value;
    return this;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public ProductCatalogHotelsItemGet setFieldImages(List<String> value) {
    this.mImages = value;
    return this;
  }

  public String getFieldLowestBasePrice() {
    return mLowestBasePrice;
  }

  public ProductCatalogHotelsItemGet setFieldLowestBasePrice(String value) {
    this.mLowestBasePrice = value;
    return this;
  }

  public String getFieldLoyaltyProgram() {
    return mLoyaltyProgram;
  }

  public ProductCatalogHotelsItemGet setFieldLoyaltyProgram(String value) {
    this.mLoyaltyProgram = value;
    return this;
  }

  public Long getFieldMarginLevel() {
    return mMarginLevel;
  }

  public ProductCatalogHotelsItemGet setFieldMarginLevel(Long value) {
    this.mMarginLevel = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public ProductCatalogHotelsItemGet setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Long getFieldNumberOfRooms() {
    return mNumberOfRooms;
  }

  public ProductCatalogHotelsItemGet setFieldNumberOfRooms(Long value) {
    this.mNumberOfRooms = value;
    return this;
  }

  public String getFieldPhone() {
    return mPhone;
  }

  public ProductCatalogHotelsItemGet setFieldPhone(String value) {
    this.mPhone = value;
    return this;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public ProductCatalogHotelsItemGet setFieldPrice(String value) {
    this.mPrice = value;
    return this;
  }

  public Double getFieldProductPriority0() {
    return mProductPriority0;
  }

  public ProductCatalogHotelsItemGet setFieldProductPriority0(Double value) {
    this.mProductPriority0 = value;
    return this;
  }

  public Double getFieldProductPriority1() {
    return mProductPriority1;
  }

  public ProductCatalogHotelsItemGet setFieldProductPriority1(Double value) {
    this.mProductPriority1 = value;
    return this;
  }

  public Double getFieldProductPriority2() {
    return mProductPriority2;
  }

  public ProductCatalogHotelsItemGet setFieldProductPriority2(Double value) {
    this.mProductPriority2 = value;
    return this;
  }

  public Double getFieldProductPriority3() {
    return mProductPriority3;
  }

  public ProductCatalogHotelsItemGet setFieldProductPriority3(Double value) {
    this.mProductPriority3 = value;
    return this;
  }

  public Double getFieldProductPriority4() {
    return mProductPriority4;
  }

  public ProductCatalogHotelsItemGet setFieldProductPriority4(Double value) {
    this.mProductPriority4 = value;
    return this;
  }

  public String getFieldRetailerId() {
    return mRetailerId;
  }

  public ProductCatalogHotelsItemGet setFieldRetailerId(String value) {
    this.mRetailerId = value;
    return this;
  }

  public String getFieldSalePrice() {
    return mSalePrice;
  }

  public ProductCatalogHotelsItemGet setFieldSalePrice(String value) {
    this.mSalePrice = value;
    return this;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public ProductCatalogHotelsItemGet setFieldSanitizedImages(List<String> value) {
    this.mSanitizedImages = value;
    return this;
  }

  public Double getFieldStarRating() {
    return mStarRating;
  }

  public ProductCatalogHotelsItemGet setFieldStarRating(Double value) {
    this.mStarRating = value;
    return this;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public ProductCatalogHotelsItemGet setFieldTags(List<String> value) {
    this.mTags = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public ProductCatalogHotelsItemGet setFieldUrl(String value) {
    this.mUrl = value;
    return this;
  }

  public List<String> getFieldVideoUrls() {
    return mVideoUrls;
  }

  public ProductCatalogHotelsItemGet setFieldVideoUrls(List<String> value) {
    this.mVideoUrls = value;
    return this;
  }

  public Object getFieldVideosMetadata() {
    return mVideosMetadata;
  }

  public ProductCatalogHotelsItemGet setFieldVideosMetadata(Object value) {
    this.mVideosMetadata = value;
    return this;
  }

  public String getFieldVisibility() {
    return mVisibility;
  }

  public ProductCatalogHotelsItemGet setFieldVisibility(String value) {
    this.mVisibility = value;
    return this;
  }



  public static enum EnumDisplayFormat {
      @SerializedName("CAROUSEL_AD")
      VALUE_CAROUSEL_AD("CAROUSEL_AD"),
      @SerializedName("SHOPS_PDP")
      VALUE_SHOPS_PDP("SHOPS_PDP"),
      @SerializedName("SINGLE_AD")
      VALUE_SINGLE_AD("SINGLE_AD"),
      ;

      private String value;

      private EnumDisplayFormat(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public ProductCatalogHotelsItemGet copyFrom(ProductCatalogHotelsItemGet instance) {
    this.mAdditionalImageUrls = instance.mAdditionalImageUrls;
    this.mAddress = instance.mAddress;
    this.mApplinkAndroidAppName = instance.mApplinkAndroidAppName;
    this.mApplinkAndroidClass = instance.mApplinkAndroidClass;
    this.mApplinkAndroidPackage = instance.mApplinkAndroidPackage;
    this.mApplinkAndroidUrl = instance.mApplinkAndroidUrl;
    this.mApplinkIosAppName = instance.mApplinkIosAppName;
    this.mApplinkIosAppStoreId = instance.mApplinkIosAppStoreId;
    this.mApplinkIosUrl = instance.mApplinkIosUrl;
    this.mApplinks = instance.mApplinks;
    this.mBrand = instance.mBrand;
    this.mCategory = instance.mCategory;
    this.mCurrency = instance.mCurrency;
    this.mCustomLabel0 = instance.mCustomLabel0;
    this.mCustomLabel1 = instance.mCustomLabel1;
    this.mCustomLabel2 = instance.mCustomLabel2;
    this.mCustomLabel3 = instance.mCustomLabel3;
    this.mCustomLabel4 = instance.mCustomLabel4;
    this.mCustomNumber0 = instance.mCustomNumber0;
    this.mCustomNumber1 = instance.mCustomNumber1;
    this.mCustomNumber2 = instance.mCustomNumber2;
    this.mCustomNumber3 = instance.mCustomNumber3;
    this.mCustomNumber4 = instance.mCustomNumber4;
    this.mDaDisplayPreviewUrl = instance.mDaDisplayPreviewUrl;
    this.mDescription = instance.mDescription;
    this.mGuestRatings = instance.mGuestRatings;
    this.mHotelId = instance.mHotelId;
    this.mId = instance.mId;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImageUrl = instance.mImageUrl;
    this.mImages = instance.mImages;
    this.mLowestBasePrice = instance.mLowestBasePrice;
    this.mLoyaltyProgram = instance.mLoyaltyProgram;
    this.mMarginLevel = instance.mMarginLevel;
    this.mName = instance.mName;
    this.mNumberOfRooms = instance.mNumberOfRooms;
    this.mPhone = instance.mPhone;
    this.mPrice = instance.mPrice;
    this.mProductPriority0 = instance.mProductPriority0;
    this.mProductPriority1 = instance.mProductPriority1;
    this.mProductPriority2 = instance.mProductPriority2;
    this.mProductPriority3 = instance.mProductPriority3;
    this.mProductPriority4 = instance.mProductPriority4;
    this.mRetailerId = instance.mRetailerId;
    this.mSalePrice = instance.mSalePrice;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mStarRating = instance.mStarRating;
    this.mTags = instance.mTags;
    this.mUrl = instance.mUrl;
    this.mVideoUrls = instance.mVideoUrls;
    this.mVideosMetadata = instance.mVideosMetadata;
    this.mVisibility = instance.mVisibility;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductCatalogHotelsItemGet> getParser() {
    return new APIRequest.ResponseParser<ProductCatalogHotelsItemGet>() {
      public APINodeList<ProductCatalogHotelsItemGet> parseResponse(String response, APIContext context, APIRequest<ProductCatalogHotelsItemGet> request, String header) throws MalformedResponseException {
        return ProductCatalogHotelsItemGet.parseResponse(response, context, request, header);
      }
    };
  }
}
