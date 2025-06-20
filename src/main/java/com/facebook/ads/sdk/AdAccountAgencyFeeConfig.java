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
public class AdAccountAgencyFeeConfig extends APINode {
  @SerializedName("can_add_agency_fee_to_invoice")
  private Boolean mCanAddAgencyFeeToInvoice = null;
  @SerializedName("default_agency_fee_pct")
  private Double mDefaultAgencyFeePct = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_agency_fee_disabled")
  private Boolean mIsAgencyFeeDisabled = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  protected static Gson gson = null;

  AdAccountAgencyFeeConfig() {
  }

  public AdAccountAgencyFeeConfig(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccountAgencyFeeConfig(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAccountAgencyFeeConfig fetch() throws APIException{
    AdAccountAgencyFeeConfig newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAccountAgencyFeeConfig fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccountAgencyFeeConfig> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccountAgencyFeeConfig fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAccountAgencyFeeConfig> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAccountAgencyFeeConfig> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccountAgencyFeeConfig>)(
      new APIRequest<AdAccountAgencyFeeConfig>(context, "", "/", "GET", AdAccountAgencyFeeConfig.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccountAgencyFeeConfig>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAccountAgencyFeeConfig.getParser())
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
  public static AdAccountAgencyFeeConfig loadJSON(String json, APIContext context, String header) {
    AdAccountAgencyFeeConfig adAccountAgencyFeeConfig = getGson().fromJson(json, AdAccountAgencyFeeConfig.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountAgencyFeeConfig.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountAgencyFeeConfig.context = context;
    adAccountAgencyFeeConfig.rawValue = json;
    adAccountAgencyFeeConfig.header = header;
    return adAccountAgencyFeeConfig;
  }

  public static APINodeList<AdAccountAgencyFeeConfig> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountAgencyFeeConfig> adAccountAgencyFeeConfigs = new APINodeList<AdAccountAgencyFeeConfig>(request, json, header);
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
          adAccountAgencyFeeConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountAgencyFeeConfigs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountAgencyFeeConfigs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountAgencyFeeConfigs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountAgencyFeeConfigs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountAgencyFeeConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountAgencyFeeConfigs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountAgencyFeeConfigs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountAgencyFeeConfigs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountAgencyFeeConfigs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountAgencyFeeConfigs;
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
              adAccountAgencyFeeConfigs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountAgencyFeeConfigs;
          }

          // Sixth, check if it's pure JsonObject
          adAccountAgencyFeeConfigs.clear();
          adAccountAgencyFeeConfigs.add(loadJSON(json, context, header));
          return adAccountAgencyFeeConfigs;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Boolean getFieldCanAddAgencyFeeToInvoice() {
    return mCanAddAgencyFeeToInvoice;
  }

  public Double getFieldDefaultAgencyFeePct() {
    return mDefaultAgencyFeePct;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsAgencyFeeDisabled() {
    return mIsAgencyFeeDisabled;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }



  public static class APIRequestGet extends APIRequest<AdAccountAgencyFeeConfig> {

    AdAccountAgencyFeeConfig lastResponse = null;
    @Override
    public AdAccountAgencyFeeConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "can_add_agency_fee_to_invoice",
      "default_agency_fee_pct",
      "id",
      "is_agency_fee_disabled",
      "status",
    };

    @Override
    public AdAccountAgencyFeeConfig parseResponse(String response, String header) throws APIException {
      return AdAccountAgencyFeeConfig.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdAccountAgencyFeeConfig execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountAgencyFeeConfig execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdAccountAgencyFeeConfig> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountAgencyFeeConfig> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdAccountAgencyFeeConfig>() {
           public AdAccountAgencyFeeConfig apply(ResponseWrapper result) {
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

    public APIRequestGet requestCanAddAgencyFeeToInvoiceField () {
      return this.requestCanAddAgencyFeeToInvoiceField(true);
    }
    public APIRequestGet requestCanAddAgencyFeeToInvoiceField (boolean value) {
      this.requestField("can_add_agency_fee_to_invoice", value);
      return this;
    }
    public APIRequestGet requestDefaultAgencyFeePctField () {
      return this.requestDefaultAgencyFeePctField(true);
    }
    public APIRequestGet requestDefaultAgencyFeePctField (boolean value) {
      this.requestField("default_agency_fee_pct", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsAgencyFeeDisabledField () {
      return this.requestIsAgencyFeeDisabledField(true);
    }
    public APIRequestGet requestIsAgencyFeeDisabledField (boolean value) {
      this.requestField("is_agency_fee_disabled", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static enum EnumStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      ;

      private String value;

      private EnumStatus(String value) {
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

  public AdAccountAgencyFeeConfig copyFrom(AdAccountAgencyFeeConfig instance) {
    this.mCanAddAgencyFeeToInvoice = instance.mCanAddAgencyFeeToInvoice;
    this.mDefaultAgencyFeePct = instance.mDefaultAgencyFeePct;
    this.mId = instance.mId;
    this.mIsAgencyFeeDisabled = instance.mIsAgencyFeeDisabled;
    this.mStatus = instance.mStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountAgencyFeeConfig> getParser() {
    return new APIRequest.ResponseParser<AdAccountAgencyFeeConfig>() {
      public APINodeList<AdAccountAgencyFeeConfig> parseResponse(String response, APIContext context, APIRequest<AdAccountAgencyFeeConfig> request, String header) throws MalformedResponseException {
        return AdAccountAgencyFeeConfig.parseResponse(response, context, request, header);
      }
    };
  }
}
