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
public class Flight extends APINode {
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
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
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("destination_airport")
  private String mDestinationAirport = null;
  @SerializedName("destination_city")
  private String mDestinationCity = null;
  @SerializedName("flight_id")
  private String mFlightId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_fetch_status")
  private EnumImageFetchStatus mImageFetchStatus = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("oneway_currency")
  private String mOnewayCurrency = null;
  @SerializedName("oneway_price")
  private String mOnewayPrice = null;
  @SerializedName("origin_airport")
  private String mOriginAirport = null;
  @SerializedName("origin_city")
  private String mOriginCity = null;
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
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("unit_price")
  private Object mUnitPrice = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("visibility")
  private EnumVisibility mVisibility = null;
  protected static Gson gson = null;

  Flight() {
  }

  public Flight(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Flight(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Flight fetch() throws APIException{
    Flight newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Flight fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Flight> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Flight fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Flight> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Flight> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Flight>)(
      new APIRequest<Flight>(context, "", "/", "GET", Flight.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Flight>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Flight.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static Flight loadJSON(String json, APIContext context, String header) {
    Flight flight = getGson().fromJson(json, Flight.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(flight.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    flight.context = context;
    flight.rawValue = json;
    flight.header = header;
    return flight;
  }

  public static APINodeList<Flight> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Flight> flights = new APINodeList<Flight>(request, json, header);
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
          flights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return flights;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                flights.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            flights.setPaging(previous, next);
            if (context.hasAppSecret()) {
              flights.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              flights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  flights.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              flights.add(loadJSON(obj.toString(), context, header));
            }
          }
          return flights;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              flights.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return flights;
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
              flights.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return flights;
          }

          // Sixth, check if it's pure JsonObject
          flights.clear();
          flights.add(loadJSON(json, context, header));
          return flights;
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

  public APIRequestGetChannelsToIntegrityStatus getChannelsToIntegrityStatus() {
    return new APIRequestGetChannelsToIntegrityStatus(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOverrideDetails getOverrideDetails() {
    return new APIRequestGetOverrideDetails(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideosMetadata getVideosMetadata() {
    return new APIRequestGetVideosMetadata(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public CatalogItemAppLinks getFieldApplinks() {
    return mApplinks;
  }

  public CatalogSubVerticalList getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldCustomLabel0() {
    return mCustomLabel0;
  }

  public String getFieldCustomLabel1() {
    return mCustomLabel1;
  }

  public String getFieldCustomLabel2() {
    return mCustomLabel2;
  }

  public String getFieldCustomLabel3() {
    return mCustomLabel3;
  }

  public String getFieldCustomLabel4() {
    return mCustomLabel4;
  }

  public Long getFieldCustomNumber0() {
    return mCustomNumber0;
  }

  public Long getFieldCustomNumber1() {
    return mCustomNumber1;
  }

  public Long getFieldCustomNumber2() {
    return mCustomNumber2;
  }

  public Long getFieldCustomNumber3() {
    return mCustomNumber3;
  }

  public Long getFieldCustomNumber4() {
    return mCustomNumber4;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldDestinationAirport() {
    return mDestinationAirport;
  }

  public String getFieldDestinationCity() {
    return mDestinationCity;
  }

  public String getFieldFlightId() {
    return mFlightId;
  }

  public String getFieldId() {
    return mId;
  }

  public EnumImageFetchStatus getFieldImageFetchStatus() {
    return mImageFetchStatus;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public String getFieldOnewayCurrency() {
    return mOnewayCurrency;
  }

  public String getFieldOnewayPrice() {
    return mOnewayPrice;
  }

  public String getFieldOriginAirport() {
    return mOriginAirport;
  }

  public String getFieldOriginCity() {
    return mOriginCity;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public Double getFieldProductPriority0() {
    return mProductPriority0;
  }

  public Double getFieldProductPriority1() {
    return mProductPriority1;
  }

  public Double getFieldProductPriority2() {
    return mProductPriority2;
  }

  public Double getFieldProductPriority3() {
    return mProductPriority3;
  }

  public Double getFieldProductPriority4() {
    return mProductPriority4;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public Object getFieldUnitPrice() {
    return mUnitPrice;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public EnumVisibility getFieldVisibility() {
    return mVisibility;
  }



  public static class APIRequestGetChannelsToIntegrityStatus extends APIRequest<CatalogItemChannelsToIntegrityStatus> {

    APINodeList<CatalogItemChannelsToIntegrityStatus> lastResponse = null;
    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "channels",
      "rejection_information",
    };

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> parseResponse(String response, String header) throws APIException {
      return CatalogItemChannelsToIntegrityStatus.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CatalogItemChannelsToIntegrityStatus>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CatalogItemChannelsToIntegrityStatus>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CatalogItemChannelsToIntegrityStatus>>() {
           public APINodeList<CatalogItemChannelsToIntegrityStatus> apply(ResponseWrapper result) {
             try {
               return APIRequestGetChannelsToIntegrityStatus.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetChannelsToIntegrityStatus(String nodeId, APIContext context) {
      super(context, nodeId, "/channels_to_integrity_status", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetChannelsToIntegrityStatus requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetChannelsToIntegrityStatus requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetChannelsToIntegrityStatus requestChannelsField () {
      return this.requestChannelsField(true);
    }
    public APIRequestGetChannelsToIntegrityStatus requestChannelsField (boolean value) {
      this.requestField("channels", value);
      return this;
    }
    public APIRequestGetChannelsToIntegrityStatus requestRejectionInformationField () {
      return this.requestRejectionInformationField(true);
    }
    public APIRequestGetChannelsToIntegrityStatus requestRejectionInformationField (boolean value) {
      this.requestField("rejection_information", value);
      return this;
    }
  }

  public static class APIRequestGetOverrideDetails extends APIRequest<OverrideDetails> {

    APINodeList<OverrideDetails> lastResponse = null;
    @Override
    public APINodeList<OverrideDetails> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "keys",
      "type",
    };

    public static final String[] FIELDS = {
      "key",
      "type",
      "values",
    };

    @Override
    public APINodeList<OverrideDetails> parseResponse(String response, String header) throws APIException {
      return OverrideDetails.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<OverrideDetails> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OverrideDetails> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OverrideDetails>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OverrideDetails>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<OverrideDetails>>() {
           public APINodeList<OverrideDetails> apply(ResponseWrapper result) {
             try {
               return APIRequestGetOverrideDetails.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOverrideDetails(String nodeId, APIContext context) {
      super(context, nodeId, "/override_details", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOverrideDetails setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOverrideDetails setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOverrideDetails setKeys (List<String> keys) {
      this.setParam("keys", keys);
      return this;
    }
    public APIRequestGetOverrideDetails setKeys (String keys) {
      this.setParam("keys", keys);
      return this;
    }

    public APIRequestGetOverrideDetails setType (OverrideDetails.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetOverrideDetails setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetOverrideDetails requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOverrideDetails requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOverrideDetails requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOverrideDetails requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOverrideDetails requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOverrideDetails requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOverrideDetails requestKeyField () {
      return this.requestKeyField(true);
    }
    public APIRequestGetOverrideDetails requestKeyField (boolean value) {
      this.requestField("key", value);
      return this;
    }
    public APIRequestGetOverrideDetails requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetOverrideDetails requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetOverrideDetails requestValuesField () {
      return this.requestValuesField(true);
    }
    public APIRequestGetOverrideDetails requestValuesField (boolean value) {
      this.requestField("values", value);
      return this;
    }
  }

  public static class APIRequestGetVideosMetadata extends APIRequest<DynamicVideoMetadata> {

    APINodeList<DynamicVideoMetadata> lastResponse = null;
    @Override
    public APINodeList<DynamicVideoMetadata> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "tags",
      "url",
      "video",
    };

    @Override
    public APINodeList<DynamicVideoMetadata> parseResponse(String response, String header) throws APIException {
      return DynamicVideoMetadata.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<DynamicVideoMetadata> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<DynamicVideoMetadata> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<DynamicVideoMetadata>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<DynamicVideoMetadata>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<DynamicVideoMetadata>>() {
           public APINodeList<DynamicVideoMetadata> apply(ResponseWrapper result) {
             try {
               return APIRequestGetVideosMetadata.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetVideosMetadata(String nodeId, APIContext context) {
      super(context, nodeId, "/videos_metadata", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideosMetadata setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideosMetadata requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideosMetadata requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideosMetadata requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVideosMetadata requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVideosMetadata requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVideosMetadata requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGetVideosMetadata requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGetVideosMetadata requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetVideosMetadata requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetVideosMetadata requestVideoField () {
      return this.requestVideoField(true);
    }
    public APIRequestGetVideosMetadata requestVideoField (boolean value) {
      this.requestField("video", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<Flight> {

    Flight lastResponse = null;
    @Override
    public Flight getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "applinks",
      "category_specific_fields",
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
      "description",
      "destination_airport",
      "destination_city",
      "flight_id",
      "id",
      "image_fetch_status",
      "images",
      "oneway_currency",
      "oneway_price",
      "origin_airport",
      "origin_city",
      "price",
      "product_priority_0",
      "product_priority_1",
      "product_priority_2",
      "product_priority_3",
      "product_priority_4",
      "sanitized_images",
      "tags",
      "unit_price",
      "url",
      "visibility",
    };

    @Override
    public Flight parseResponse(String response, String header) throws APIException {
      return Flight.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Flight execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Flight execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Flight> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Flight> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Flight>() {
           public Flight apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGet requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGet requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGet requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestCustomLabel0Field () {
      return this.requestCustomLabel0Field(true);
    }
    public APIRequestGet requestCustomLabel0Field (boolean value) {
      this.requestField("custom_label_0", value);
      return this;
    }
    public APIRequestGet requestCustomLabel1Field () {
      return this.requestCustomLabel1Field(true);
    }
    public APIRequestGet requestCustomLabel1Field (boolean value) {
      this.requestField("custom_label_1", value);
      return this;
    }
    public APIRequestGet requestCustomLabel2Field () {
      return this.requestCustomLabel2Field(true);
    }
    public APIRequestGet requestCustomLabel2Field (boolean value) {
      this.requestField("custom_label_2", value);
      return this;
    }
    public APIRequestGet requestCustomLabel3Field () {
      return this.requestCustomLabel3Field(true);
    }
    public APIRequestGet requestCustomLabel3Field (boolean value) {
      this.requestField("custom_label_3", value);
      return this;
    }
    public APIRequestGet requestCustomLabel4Field () {
      return this.requestCustomLabel4Field(true);
    }
    public APIRequestGet requestCustomLabel4Field (boolean value) {
      this.requestField("custom_label_4", value);
      return this;
    }
    public APIRequestGet requestCustomNumber0Field () {
      return this.requestCustomNumber0Field(true);
    }
    public APIRequestGet requestCustomNumber0Field (boolean value) {
      this.requestField("custom_number_0", value);
      return this;
    }
    public APIRequestGet requestCustomNumber1Field () {
      return this.requestCustomNumber1Field(true);
    }
    public APIRequestGet requestCustomNumber1Field (boolean value) {
      this.requestField("custom_number_1", value);
      return this;
    }
    public APIRequestGet requestCustomNumber2Field () {
      return this.requestCustomNumber2Field(true);
    }
    public APIRequestGet requestCustomNumber2Field (boolean value) {
      this.requestField("custom_number_2", value);
      return this;
    }
    public APIRequestGet requestCustomNumber3Field () {
      return this.requestCustomNumber3Field(true);
    }
    public APIRequestGet requestCustomNumber3Field (boolean value) {
      this.requestField("custom_number_3", value);
      return this;
    }
    public APIRequestGet requestCustomNumber4Field () {
      return this.requestCustomNumber4Field(true);
    }
    public APIRequestGet requestCustomNumber4Field (boolean value) {
      this.requestField("custom_number_4", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDestinationAirportField () {
      return this.requestDestinationAirportField(true);
    }
    public APIRequestGet requestDestinationAirportField (boolean value) {
      this.requestField("destination_airport", value);
      return this;
    }
    public APIRequestGet requestDestinationCityField () {
      return this.requestDestinationCityField(true);
    }
    public APIRequestGet requestDestinationCityField (boolean value) {
      this.requestField("destination_city", value);
      return this;
    }
    public APIRequestGet requestFlightIdField () {
      return this.requestFlightIdField(true);
    }
    public APIRequestGet requestFlightIdField (boolean value) {
      this.requestField("flight_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGet requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGet requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGet requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGet requestOnewayCurrencyField () {
      return this.requestOnewayCurrencyField(true);
    }
    public APIRequestGet requestOnewayCurrencyField (boolean value) {
      this.requestField("oneway_currency", value);
      return this;
    }
    public APIRequestGet requestOnewayPriceField () {
      return this.requestOnewayPriceField(true);
    }
    public APIRequestGet requestOnewayPriceField (boolean value) {
      this.requestField("oneway_price", value);
      return this;
    }
    public APIRequestGet requestOriginAirportField () {
      return this.requestOriginAirportField(true);
    }
    public APIRequestGet requestOriginAirportField (boolean value) {
      this.requestField("origin_airport", value);
      return this;
    }
    public APIRequestGet requestOriginCityField () {
      return this.requestOriginCityField(true);
    }
    public APIRequestGet requestOriginCityField (boolean value) {
      this.requestField("origin_city", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestProductPriority0Field () {
      return this.requestProductPriority0Field(true);
    }
    public APIRequestGet requestProductPriority0Field (boolean value) {
      this.requestField("product_priority_0", value);
      return this;
    }
    public APIRequestGet requestProductPriority1Field () {
      return this.requestProductPriority1Field(true);
    }
    public APIRequestGet requestProductPriority1Field (boolean value) {
      this.requestField("product_priority_1", value);
      return this;
    }
    public APIRequestGet requestProductPriority2Field () {
      return this.requestProductPriority2Field(true);
    }
    public APIRequestGet requestProductPriority2Field (boolean value) {
      this.requestField("product_priority_2", value);
      return this;
    }
    public APIRequestGet requestProductPriority3Field () {
      return this.requestProductPriority3Field(true);
    }
    public APIRequestGet requestProductPriority3Field (boolean value) {
      this.requestField("product_priority_3", value);
      return this;
    }
    public APIRequestGet requestProductPriority4Field () {
      return this.requestProductPriority4Field(true);
    }
    public APIRequestGet requestProductPriority4Field (boolean value) {
      this.requestField("product_priority_4", value);
      return this;
    }
    public APIRequestGet requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGet requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGet requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGet requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGet requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGet requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGet requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Flight> {

    Flight lastResponse = null;
    @Override
    public Flight getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "currency",
      "description",
      "destination_airport",
      "destination_city",
      "images",
      "origin_airport",
      "origin_city",
      "price",
      "url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Flight parseResponse(String response, String header) throws APIException {
      return Flight.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Flight execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Flight execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Flight> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Flight> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Flight>() {
           public Flight apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setDestinationAirport (String destinationAirport) {
      this.setParam("destination_airport", destinationAirport);
      return this;
    }

    public APIRequestUpdate setDestinationCity (String destinationCity) {
      this.setParam("destination_city", destinationCity);
      return this;
    }

    public APIRequestUpdate setImages (List<Object> images) {
      this.setParam("images", images);
      return this;
    }
    public APIRequestUpdate setImages (String images) {
      this.setParam("images", images);
      return this;
    }

    public APIRequestUpdate setOriginAirport (String originAirport) {
      this.setParam("origin_airport", originAirport);
      return this;
    }

    public APIRequestUpdate setOriginCity (String originCity) {
      this.setParam("origin_city", originCity);
      return this;
    }

    public APIRequestUpdate setPrice (Long price) {
      this.setParam("price", price);
      return this;
    }
    public APIRequestUpdate setPrice (String price) {
      this.setParam("price", price);
      return this;
    }

    public APIRequestUpdate setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumImageFetchStatus {
      @SerializedName("DIRECT_UPLOAD")
      VALUE_DIRECT_UPLOAD("DIRECT_UPLOAD"),
      @SerializedName("FETCHED")
      VALUE_FETCHED("FETCHED"),
      @SerializedName("FETCH_FAILED")
      VALUE_FETCH_FAILED("FETCH_FAILED"),
      @SerializedName("NO_STATUS")
      VALUE_NO_STATUS("NO_STATUS"),
      @SerializedName("OUTDATED")
      VALUE_OUTDATED("OUTDATED"),
      @SerializedName("PARTIAL_FETCH")
      VALUE_PARTIAL_FETCH("PARTIAL_FETCH"),
      ;

      private String value;

      private EnumImageFetchStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVisibility {
      @SerializedName("PUBLISHED")
      VALUE_PUBLISHED("PUBLISHED"),
      @SerializedName("STAGING")
      VALUE_STAGING("STAGING"),
      ;

      private String value;

      private EnumVisibility(String value) {
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

  public Flight copyFrom(Flight instance) {
    this.mApplinks = instance.mApplinks;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
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
    this.mDescription = instance.mDescription;
    this.mDestinationAirport = instance.mDestinationAirport;
    this.mDestinationCity = instance.mDestinationCity;
    this.mFlightId = instance.mFlightId;
    this.mId = instance.mId;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImages = instance.mImages;
    this.mOnewayCurrency = instance.mOnewayCurrency;
    this.mOnewayPrice = instance.mOnewayPrice;
    this.mOriginAirport = instance.mOriginAirport;
    this.mOriginCity = instance.mOriginCity;
    this.mPrice = instance.mPrice;
    this.mProductPriority0 = instance.mProductPriority0;
    this.mProductPriority1 = instance.mProductPriority1;
    this.mProductPriority2 = instance.mProductPriority2;
    this.mProductPriority3 = instance.mProductPriority3;
    this.mProductPriority4 = instance.mProductPriority4;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mTags = instance.mTags;
    this.mUnitPrice = instance.mUnitPrice;
    this.mUrl = instance.mUrl;
    this.mVisibility = instance.mVisibility;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Flight> getParser() {
    return new APIRequest.ResponseParser<Flight>() {
      public APINodeList<Flight> parseResponse(String response, APIContext context, APIRequest<Flight> request, String header) throws MalformedResponseException {
        return Flight.parseResponse(response, context, request, header);
      }
    };
  }
}
