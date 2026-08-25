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
public class ProductCatalogHotelsItem extends APINode {
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public ProductCatalogHotelsItem() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductCatalogHotelsItem loadJSON(String json, APIContext context, String header) {
    ProductCatalogHotelsItem productCatalogHotelsItem = getGson().fromJson(json, ProductCatalogHotelsItem.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productCatalogHotelsItem.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productCatalogHotelsItem.context = context;
    productCatalogHotelsItem.rawValue = json;
    productCatalogHotelsItem.header = header;
    return productCatalogHotelsItem;
  }

  public static APINodeList<ProductCatalogHotelsItem> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductCatalogHotelsItem> productCatalogHotelsItems = new APINodeList<ProductCatalogHotelsItem>(request, json, header);
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
          productCatalogHotelsItems.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productCatalogHotelsItems;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productCatalogHotelsItems.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productCatalogHotelsItems.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productCatalogHotelsItems.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productCatalogHotelsItems.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productCatalogHotelsItems.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productCatalogHotelsItems.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productCatalogHotelsItems;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productCatalogHotelsItems.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productCatalogHotelsItems;
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
              productCatalogHotelsItems.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productCatalogHotelsItems;
          }

          // Sixth, check if it's pure JsonObject
          productCatalogHotelsItems.clear();
          productCatalogHotelsItems.add(loadJSON(json, context, header));
          return productCatalogHotelsItems;
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

  public APIRequestGenget genget() {
    return new APIRequestGenget(this.getId(), context);
  }


  public String getFieldId() {
    return mId;
  }

  public ProductCatalogHotelsItem setFieldId(String value) {
    this.mId = value;
    return this;
  }



  public static class APIRequestGenget extends APIRequest<ProductCatalogHotelsItemGet> {

    APINodeList<ProductCatalogHotelsItemGet> lastResponse = null;
    @Override
    public APINodeList<ProductCatalogHotelsItemGet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "display_format",
    };

    public static final String[] FIELDS = {
      "additional_image_urls",
      "address",
      "applink_android_app_name",
      "applink_android_class",
      "applink_android_package",
      "applink_android_url",
      "applink_ios_app_name",
      "applink_ios_app_store_id",
      "applink_ios_url",
      "applinks",
      "brand",
      "category",
      "currency",
      "custom_label_0",
      "custom_label_1",
      "custom_label_2",
      "custom_label_3",
      "custom_label_4",
      "custom_number_0",
      "custom_number_1",
      "custom_number_2",
      "custom_number_3",
      "custom_number_4",
      "da_display_preview_url",
      "description",
      "guest_ratings",
      "hotel_id",
      "id",
      "image_fetch_status",
      "image_url",
      "images",
      "lowest_base_price",
      "loyalty_program",
      "margin_level",
      "name",
      "number_of_rooms",
      "phone",
      "price",
      "product_priority_0",
      "product_priority_1",
      "product_priority_2",
      "product_priority_3",
      "product_priority_4",
      "retailer_id",
      "sale_price",
      "sanitized_images",
      "star_rating",
      "tags",
      "url",
      "video_urls",
      "videos_metadata",
      "visibility",
    };

    @Override
    public APINodeList<ProductCatalogHotelsItemGet> parseResponse(String response, String header) throws APIException {
      return ProductCatalogHotelsItemGet.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductCatalogHotelsItemGet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalogHotelsItemGet> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalogHotelsItemGet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalogHotelsItemGet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductCatalogHotelsItemGet>>() {
           public APINodeList<ProductCatalogHotelsItemGet> apply(ResponseWrapper result) {
             try {
               return APIRequestGenget.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGenget(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGenget setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGenget setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGenget setDisplayFormat (ProductCatalogHotelsItemGet.EnumDisplayFormat displayFormat) {
      this.setParam("display_format", displayFormat);
      return this;
    }
    public APIRequestGenget setDisplayFormat (String displayFormat) {
      this.setParam("display_format", displayFormat);
      return this;
    }

    public APIRequestGenget requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGenget requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGenget requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGenget requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGenget requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGenget requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGenget requestAdditionalImageUrlsField () {
      return this.requestAdditionalImageUrlsField(true);
    }
    public APIRequestGenget requestAdditionalImageUrlsField (boolean value) {
      this.requestField("additional_image_urls", value);
      return this;
    }
    public APIRequestGenget requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGenget requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGenget requestApplinkAndroidAppNameField () {
      return this.requestApplinkAndroidAppNameField(true);
    }
    public APIRequestGenget requestApplinkAndroidAppNameField (boolean value) {
      this.requestField("applink_android_app_name", value);
      return this;
    }
    public APIRequestGenget requestApplinkAndroidClassField () {
      return this.requestApplinkAndroidClassField(true);
    }
    public APIRequestGenget requestApplinkAndroidClassField (boolean value) {
      this.requestField("applink_android_class", value);
      return this;
    }
    public APIRequestGenget requestApplinkAndroidPackageField () {
      return this.requestApplinkAndroidPackageField(true);
    }
    public APIRequestGenget requestApplinkAndroidPackageField (boolean value) {
      this.requestField("applink_android_package", value);
      return this;
    }
    public APIRequestGenget requestApplinkAndroidUrlField () {
      return this.requestApplinkAndroidUrlField(true);
    }
    public APIRequestGenget requestApplinkAndroidUrlField (boolean value) {
      this.requestField("applink_android_url", value);
      return this;
    }
    public APIRequestGenget requestApplinkIosAppNameField () {
      return this.requestApplinkIosAppNameField(true);
    }
    public APIRequestGenget requestApplinkIosAppNameField (boolean value) {
      this.requestField("applink_ios_app_name", value);
      return this;
    }
    public APIRequestGenget requestApplinkIosAppStoreIdField () {
      return this.requestApplinkIosAppStoreIdField(true);
    }
    public APIRequestGenget requestApplinkIosAppStoreIdField (boolean value) {
      this.requestField("applink_ios_app_store_id", value);
      return this;
    }
    public APIRequestGenget requestApplinkIosUrlField () {
      return this.requestApplinkIosUrlField(true);
    }
    public APIRequestGenget requestApplinkIosUrlField (boolean value) {
      this.requestField("applink_ios_url", value);
      return this;
    }
    public APIRequestGenget requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGenget requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGenget requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGenget requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGenget requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGenget requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGenget requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGenget requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGenget requestCustomLabel0Field () {
      return this.requestCustomLabel0Field(true);
    }
    public APIRequestGenget requestCustomLabel0Field (boolean value) {
      this.requestField("custom_label_0", value);
      return this;
    }
    public APIRequestGenget requestCustomLabel1Field () {
      return this.requestCustomLabel1Field(true);
    }
    public APIRequestGenget requestCustomLabel1Field (boolean value) {
      this.requestField("custom_label_1", value);
      return this;
    }
    public APIRequestGenget requestCustomLabel2Field () {
      return this.requestCustomLabel2Field(true);
    }
    public APIRequestGenget requestCustomLabel2Field (boolean value) {
      this.requestField("custom_label_2", value);
      return this;
    }
    public APIRequestGenget requestCustomLabel3Field () {
      return this.requestCustomLabel3Field(true);
    }
    public APIRequestGenget requestCustomLabel3Field (boolean value) {
      this.requestField("custom_label_3", value);
      return this;
    }
    public APIRequestGenget requestCustomLabel4Field () {
      return this.requestCustomLabel4Field(true);
    }
    public APIRequestGenget requestCustomLabel4Field (boolean value) {
      this.requestField("custom_label_4", value);
      return this;
    }
    public APIRequestGenget requestCustomNumber0Field () {
      return this.requestCustomNumber0Field(true);
    }
    public APIRequestGenget requestCustomNumber0Field (boolean value) {
      this.requestField("custom_number_0", value);
      return this;
    }
    public APIRequestGenget requestCustomNumber1Field () {
      return this.requestCustomNumber1Field(true);
    }
    public APIRequestGenget requestCustomNumber1Field (boolean value) {
      this.requestField("custom_number_1", value);
      return this;
    }
    public APIRequestGenget requestCustomNumber2Field () {
      return this.requestCustomNumber2Field(true);
    }
    public APIRequestGenget requestCustomNumber2Field (boolean value) {
      this.requestField("custom_number_2", value);
      return this;
    }
    public APIRequestGenget requestCustomNumber3Field () {
      return this.requestCustomNumber3Field(true);
    }
    public APIRequestGenget requestCustomNumber3Field (boolean value) {
      this.requestField("custom_number_3", value);
      return this;
    }
    public APIRequestGenget requestCustomNumber4Field () {
      return this.requestCustomNumber4Field(true);
    }
    public APIRequestGenget requestCustomNumber4Field (boolean value) {
      this.requestField("custom_number_4", value);
      return this;
    }
    public APIRequestGenget requestDaDisplayPreviewUrlField () {
      return this.requestDaDisplayPreviewUrlField(true);
    }
    public APIRequestGenget requestDaDisplayPreviewUrlField (boolean value) {
      this.requestField("da_display_preview_url", value);
      return this;
    }
    public APIRequestGenget requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGenget requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGenget requestGuestRatingsField () {
      return this.requestGuestRatingsField(true);
    }
    public APIRequestGenget requestGuestRatingsField (boolean value) {
      this.requestField("guest_ratings", value);
      return this;
    }
    public APIRequestGenget requestHotelIdField () {
      return this.requestHotelIdField(true);
    }
    public APIRequestGenget requestHotelIdField (boolean value) {
      this.requestField("hotel_id", value);
      return this;
    }
    public APIRequestGenget requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGenget requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGenget requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGenget requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGenget requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGenget requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGenget requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGenget requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGenget requestLowestBasePriceField () {
      return this.requestLowestBasePriceField(true);
    }
    public APIRequestGenget requestLowestBasePriceField (boolean value) {
      this.requestField("lowest_base_price", value);
      return this;
    }
    public APIRequestGenget requestLoyaltyProgramField () {
      return this.requestLoyaltyProgramField(true);
    }
    public APIRequestGenget requestLoyaltyProgramField (boolean value) {
      this.requestField("loyalty_program", value);
      return this;
    }
    public APIRequestGenget requestMarginLevelField () {
      return this.requestMarginLevelField(true);
    }
    public APIRequestGenget requestMarginLevelField (boolean value) {
      this.requestField("margin_level", value);
      return this;
    }
    public APIRequestGenget requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGenget requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGenget requestNumberOfRoomsField () {
      return this.requestNumberOfRoomsField(true);
    }
    public APIRequestGenget requestNumberOfRoomsField (boolean value) {
      this.requestField("number_of_rooms", value);
      return this;
    }
    public APIRequestGenget requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGenget requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGenget requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGenget requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGenget requestProductPriority0Field () {
      return this.requestProductPriority0Field(true);
    }
    public APIRequestGenget requestProductPriority0Field (boolean value) {
      this.requestField("product_priority_0", value);
      return this;
    }
    public APIRequestGenget requestProductPriority1Field () {
      return this.requestProductPriority1Field(true);
    }
    public APIRequestGenget requestProductPriority1Field (boolean value) {
      this.requestField("product_priority_1", value);
      return this;
    }
    public APIRequestGenget requestProductPriority2Field () {
      return this.requestProductPriority2Field(true);
    }
    public APIRequestGenget requestProductPriority2Field (boolean value) {
      this.requestField("product_priority_2", value);
      return this;
    }
    public APIRequestGenget requestProductPriority3Field () {
      return this.requestProductPriority3Field(true);
    }
    public APIRequestGenget requestProductPriority3Field (boolean value) {
      this.requestField("product_priority_3", value);
      return this;
    }
    public APIRequestGenget requestProductPriority4Field () {
      return this.requestProductPriority4Field(true);
    }
    public APIRequestGenget requestProductPriority4Field (boolean value) {
      this.requestField("product_priority_4", value);
      return this;
    }
    public APIRequestGenget requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGenget requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGenget requestSalePriceField () {
      return this.requestSalePriceField(true);
    }
    public APIRequestGenget requestSalePriceField (boolean value) {
      this.requestField("sale_price", value);
      return this;
    }
    public APIRequestGenget requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGenget requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGenget requestStarRatingField () {
      return this.requestStarRatingField(true);
    }
    public APIRequestGenget requestStarRatingField (boolean value) {
      this.requestField("star_rating", value);
      return this;
    }
    public APIRequestGenget requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGenget requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGenget requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGenget requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGenget requestVideoUrlsField () {
      return this.requestVideoUrlsField(true);
    }
    public APIRequestGenget requestVideoUrlsField (boolean value) {
      this.requestField("video_urls", value);
      return this;
    }
    public APIRequestGenget requestVideosMetadataField () {
      return this.requestVideosMetadataField(true);
    }
    public APIRequestGenget requestVideosMetadataField (boolean value) {
      this.requestField("videos_metadata", value);
      return this;
    }
    public APIRequestGenget requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGenget requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
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

  public ProductCatalogHotelsItem copyFrom(ProductCatalogHotelsItem instance) {
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductCatalogHotelsItem> getParser() {
    return new APIRequest.ResponseParser<ProductCatalogHotelsItem>() {
      public APINodeList<ProductCatalogHotelsItem> parseResponse(String response, APIContext context, APIRequest<ProductCatalogHotelsItem> request, String header) throws MalformedResponseException {
        return ProductCatalogHotelsItem.parseResponse(response, context, request, header);
      }
    };
  }
}
