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
public class IntegrityAppeal extends APINode {
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public IntegrityAppeal() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static IntegrityAppeal loadJSON(String json, APIContext context, String header) {
    IntegrityAppeal integrityAppeal = getGson().fromJson(json, IntegrityAppeal.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(integrityAppeal.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    integrityAppeal.context = context;
    integrityAppeal.rawValue = json;
    integrityAppeal.header = header;
    return integrityAppeal;
  }

  public static APINodeList<IntegrityAppeal> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IntegrityAppeal> integrityAppeals = new APINodeList<IntegrityAppeal>(request, json, header);
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
          integrityAppeals.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return integrityAppeals;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                integrityAppeals.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            integrityAppeals.setPaging(previous, next);
            if (context.hasAppSecret()) {
              integrityAppeals.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              integrityAppeals.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  integrityAppeals.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              integrityAppeals.add(loadJSON(obj.toString(), context, header));
            }
          }
          return integrityAppeals;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              integrityAppeals.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return integrityAppeals;
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
              integrityAppeals.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return integrityAppeals;
          }

          // Sixth, check if it's pure JsonObject
          integrityAppeals.clear();
          integrityAppeals.add(loadJSON(json, context, header));
          return integrityAppeals;
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

  public APIRequestGengetadappealbulkeligibility gengetadappealbulkeligibility() {
    return new APIRequestGengetadappealbulkeligibility(this.getId(), context);
  }

  public APIRequestGengetadappealbulkstatus gengetadappealbulkstatus() {
    return new APIRequestGengetadappealbulkstatus(this.getId(), context);
  }

  public APIRequestGengetadappealeligibility gengetadappealeligibility() {
    return new APIRequestGengetadappealeligibility(this.getId(), context);
  }

  public APIRequestGengetadappealstatus gengetadappealstatus() {
    return new APIRequestGengetadappealstatus(this.getId(), context);
  }

  public APIRequestGenpostadappealbulk genpostadappealbulk() {
    return new APIRequestGenpostadappealbulk(this.getId(), context);
  }


  public String getFieldId() {
    return mId;
  }

  public IntegrityAppeal setFieldId(String value) {
    this.mId = value;
    return this;
  }



  public static class APIRequestGengetadappealbulkeligibility extends APIRequest<IntegrityAppealGetAdAppealBulkEligibility> {

    APINodeList<IntegrityAppealGetAdAppealBulkEligibility> lastResponse = null;
    @Override
    public APINodeList<IntegrityAppealGetAdAppealBulkEligibility> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_ids",
    };

    public static final String[] FIELDS = {
      "results",
    };

    @Override
    public APINodeList<IntegrityAppealGetAdAppealBulkEligibility> parseResponse(String response, String header) throws APIException {
      return IntegrityAppealGetAdAppealBulkEligibility.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IntegrityAppealGetAdAppealBulkEligibility> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IntegrityAppealGetAdAppealBulkEligibility> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IntegrityAppealGetAdAppealBulkEligibility>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IntegrityAppealGetAdAppealBulkEligibility>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IntegrityAppealGetAdAppealBulkEligibility>>() {
           public APINodeList<IntegrityAppealGetAdAppealBulkEligibility> apply(ResponseWrapper result) {
             try {
               return APIRequestGengetadappealbulkeligibility.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGengetadappealbulkeligibility(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGengetadappealbulkeligibility setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGengetadappealbulkeligibility setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGengetadappealbulkeligibility setAdIds (List<Long> adIds) {
      this.setParam("ad_ids", adIds);
      return this;
    }
    public APIRequestGengetadappealbulkeligibility setAdIds (String adIds) {
      this.setParam("ad_ids", adIds);
      return this;
    }

    public APIRequestGengetadappealbulkeligibility requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGengetadappealbulkeligibility requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGengetadappealbulkeligibility requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGengetadappealbulkeligibility requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGengetadappealbulkeligibility requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGengetadappealbulkeligibility requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGengetadappealbulkeligibility requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGengetadappealbulkeligibility requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
  }

  public static class APIRequestGengetadappealbulkstatus extends APIRequest<IntegrityAppealGetAdAppealBulkStatus> {

    APINodeList<IntegrityAppealGetAdAppealBulkStatus> lastResponse = null;
    @Override
    public APINodeList<IntegrityAppealGetAdAppealBulkStatus> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_ids",
    };

    public static final String[] FIELDS = {
      "results",
    };

    @Override
    public APINodeList<IntegrityAppealGetAdAppealBulkStatus> parseResponse(String response, String header) throws APIException {
      return IntegrityAppealGetAdAppealBulkStatus.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IntegrityAppealGetAdAppealBulkStatus> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IntegrityAppealGetAdAppealBulkStatus> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IntegrityAppealGetAdAppealBulkStatus>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IntegrityAppealGetAdAppealBulkStatus>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IntegrityAppealGetAdAppealBulkStatus>>() {
           public APINodeList<IntegrityAppealGetAdAppealBulkStatus> apply(ResponseWrapper result) {
             try {
               return APIRequestGengetadappealbulkstatus.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGengetadappealbulkstatus(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGengetadappealbulkstatus setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGengetadappealbulkstatus setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGengetadappealbulkstatus setAdIds (List<Long> adIds) {
      this.setParam("ad_ids", adIds);
      return this;
    }
    public APIRequestGengetadappealbulkstatus setAdIds (String adIds) {
      this.setParam("ad_ids", adIds);
      return this;
    }

    public APIRequestGengetadappealbulkstatus requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGengetadappealbulkstatus requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGengetadappealbulkstatus requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGengetadappealbulkstatus requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGengetadappealbulkstatus requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGengetadappealbulkstatus requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGengetadappealbulkstatus requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGengetadappealbulkstatus requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
  }

  public static class APIRequestGengetadappealeligibility extends APIRequest<IntegrityAppealGetAdAppealEligibility> {

    APINodeList<IntegrityAppealGetAdAppealEligibility> lastResponse = null;
    @Override
    public APINodeList<IntegrityAppealGetAdAppealEligibility> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_id",
      "ineligibility_reason",
      "is_eligible",
    };

    @Override
    public APINodeList<IntegrityAppealGetAdAppealEligibility> parseResponse(String response, String header) throws APIException {
      return IntegrityAppealGetAdAppealEligibility.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IntegrityAppealGetAdAppealEligibility> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IntegrityAppealGetAdAppealEligibility> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IntegrityAppealGetAdAppealEligibility>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IntegrityAppealGetAdAppealEligibility>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IntegrityAppealGetAdAppealEligibility>>() {
           public APINodeList<IntegrityAppealGetAdAppealEligibility> apply(ResponseWrapper result) {
             try {
               return APIRequestGengetadappealeligibility.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGengetadappealeligibility(String nodeId, APIContext context) {
      super(context, nodeId, "/eligibility", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGengetadappealeligibility setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGengetadappealeligibility setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGengetadappealeligibility requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGengetadappealeligibility requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGengetadappealeligibility requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGengetadappealeligibility requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGengetadappealeligibility requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGengetadappealeligibility requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGengetadappealeligibility requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGengetadappealeligibility requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGengetadappealeligibility requestIneligibilityReasonField () {
      return this.requestIneligibilityReasonField(true);
    }
    public APIRequestGengetadappealeligibility requestIneligibilityReasonField (boolean value) {
      this.requestField("ineligibility_reason", value);
      return this;
    }
    public APIRequestGengetadappealeligibility requestIsEligibleField () {
      return this.requestIsEligibleField(true);
    }
    public APIRequestGengetadappealeligibility requestIsEligibleField (boolean value) {
      this.requestField("is_eligible", value);
      return this;
    }
  }

  public static class APIRequestGengetadappealstatus extends APIRequest<IntegrityAppealGetAdAppealStatus> {

    APINodeList<IntegrityAppealGetAdAppealStatus> lastResponse = null;
    @Override
    public APINodeList<IntegrityAppealGetAdAppealStatus> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_id",
      "appeal_status",
    };

    @Override
    public APINodeList<IntegrityAppealGetAdAppealStatus> parseResponse(String response, String header) throws APIException {
      return IntegrityAppealGetAdAppealStatus.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IntegrityAppealGetAdAppealStatus> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IntegrityAppealGetAdAppealStatus> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IntegrityAppealGetAdAppealStatus>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IntegrityAppealGetAdAppealStatus>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IntegrityAppealGetAdAppealStatus>>() {
           public APINodeList<IntegrityAppealGetAdAppealStatus> apply(ResponseWrapper result) {
             try {
               return APIRequestGengetadappealstatus.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGengetadappealstatus(String nodeId, APIContext context) {
      super(context, nodeId, "/status", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGengetadappealstatus setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGengetadappealstatus setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGengetadappealstatus requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGengetadappealstatus requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGengetadappealstatus requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGengetadappealstatus requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGengetadappealstatus requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGengetadappealstatus requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGengetadappealstatus requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGengetadappealstatus requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGengetadappealstatus requestAppealStatusField () {
      return this.requestAppealStatusField(true);
    }
    public APIRequestGengetadappealstatus requestAppealStatusField (boolean value) {
      this.requestField("appeal_status", value);
      return this;
    }
  }

  public static class APIRequestGenpostadappealbulk extends APIRequest<IntegrityAppealPostAdAppealBulk> {

    IntegrityAppealPostAdAppealBulk lastResponse = null;
    @Override
    public IntegrityAppealPostAdAppealBulk getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IntegrityAppealPostAdAppealBulk parseResponse(String response, String header) throws APIException {
      return IntegrityAppealPostAdAppealBulk.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IntegrityAppealPostAdAppealBulk execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IntegrityAppealPostAdAppealBulk execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IntegrityAppealPostAdAppealBulk> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IntegrityAppealPostAdAppealBulk> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IntegrityAppealPostAdAppealBulk>() {
           public IntegrityAppealPostAdAppealBulk apply(ResponseWrapper result) {
             try {
               return APIRequestGenpostadappealbulk.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGenpostadappealbulk(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGenpostadappealbulk setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGenpostadappealbulk setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGenpostadappealbulk requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGenpostadappealbulk requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGenpostadappealbulk requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGenpostadappealbulk requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGenpostadappealbulk requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGenpostadappealbulk requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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

  public IntegrityAppeal copyFrom(IntegrityAppeal instance) {
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IntegrityAppeal> getParser() {
    return new APIRequest.ResponseParser<IntegrityAppeal>() {
      public APINodeList<IntegrityAppeal> parseResponse(String response, APIContext context, APIRequest<IntegrityAppeal> request, String header) throws MalformedResponseException {
        return IntegrityAppeal.parseResponse(response, context, request, header);
      }
    };
  }
}
