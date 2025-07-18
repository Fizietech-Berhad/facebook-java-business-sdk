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
public class AdsNamingTemplate extends APINode {
  @SerializedName("api_fields")
  private List<List<Map<String, List<Map<String, String>>>>> mApiFields = null;
  @SerializedName("api_version")
  private String mApiVersion = null;
  @SerializedName("field_order")
  private List<String> mFieldOrder = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("level")
  private EnumLevel mLevel = null;
  @SerializedName("separator")
  private String mSeparator = null;
  @SerializedName("template_version")
  private String mTemplateVersion = null;
  @SerializedName("user_defined_fields")
  private List<List<Map<String, List<String>>>> mUserDefinedFields = null;
  @SerializedName("value_separator")
  private String mValueSeparator = null;
  protected static Gson gson = null;

  AdsNamingTemplate() {
  }

  public AdsNamingTemplate(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsNamingTemplate(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsNamingTemplate fetch() throws APIException{
    AdsNamingTemplate newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsNamingTemplate fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsNamingTemplate> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsNamingTemplate fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsNamingTemplate> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsNamingTemplate> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsNamingTemplate>)(
      new APIRequest<AdsNamingTemplate>(context, "", "/", "GET", AdsNamingTemplate.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsNamingTemplate>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsNamingTemplate.getParser())
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
  public static AdsNamingTemplate loadJSON(String json, APIContext context, String header) {
    AdsNamingTemplate adsNamingTemplate = getGson().fromJson(json, AdsNamingTemplate.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsNamingTemplate.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsNamingTemplate.context = context;
    adsNamingTemplate.rawValue = json;
    adsNamingTemplate.header = header;
    return adsNamingTemplate;
  }

  public static APINodeList<AdsNamingTemplate> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsNamingTemplate> adsNamingTemplates = new APINodeList<AdsNamingTemplate>(request, json, header);
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
          adsNamingTemplates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsNamingTemplates;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsNamingTemplates.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsNamingTemplates.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsNamingTemplates.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsNamingTemplates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsNamingTemplates.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsNamingTemplates.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsNamingTemplates;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsNamingTemplates.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsNamingTemplates;
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
              adsNamingTemplates.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsNamingTemplates;
          }

          // Sixth, check if it's pure JsonObject
          adsNamingTemplates.clear();
          adsNamingTemplates.add(loadJSON(json, context, header));
          return adsNamingTemplates;
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


  public List<List<Map<String, List<Map<String, String>>>>> getFieldApiFields() {
    return mApiFields;
  }

  public String getFieldApiVersion() {
    return mApiVersion;
  }

  public List<String> getFieldFieldOrder() {
    return mFieldOrder;
  }

  public String getFieldId() {
    return mId;
  }

  public EnumLevel getFieldLevel() {
    return mLevel;
  }

  public String getFieldSeparator() {
    return mSeparator;
  }

  public String getFieldTemplateVersion() {
    return mTemplateVersion;
  }

  public List<List<Map<String, List<String>>>> getFieldUserDefinedFields() {
    return mUserDefinedFields;
  }

  public String getFieldValueSeparator() {
    return mValueSeparator;
  }



  public static class APIRequestGet extends APIRequest<AdsNamingTemplate> {

    AdsNamingTemplate lastResponse = null;
    @Override
    public AdsNamingTemplate getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "api_fields",
      "api_version",
      "field_order",
      "id",
      "level",
      "separator",
      "template_version",
      "user_defined_fields",
      "value_separator",
    };

    @Override
    public AdsNamingTemplate parseResponse(String response, String header) throws APIException {
      return AdsNamingTemplate.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsNamingTemplate execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsNamingTemplate execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsNamingTemplate> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsNamingTemplate> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsNamingTemplate>() {
           public AdsNamingTemplate apply(ResponseWrapper result) {
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

    public APIRequestGet requestApiFieldsField () {
      return this.requestApiFieldsField(true);
    }
    public APIRequestGet requestApiFieldsField (boolean value) {
      this.requestField("api_fields", value);
      return this;
    }
    public APIRequestGet requestApiVersionField () {
      return this.requestApiVersionField(true);
    }
    public APIRequestGet requestApiVersionField (boolean value) {
      this.requestField("api_version", value);
      return this;
    }
    public APIRequestGet requestFieldOrderField () {
      return this.requestFieldOrderField(true);
    }
    public APIRequestGet requestFieldOrderField (boolean value) {
      this.requestField("field_order", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLevelField () {
      return this.requestLevelField(true);
    }
    public APIRequestGet requestLevelField (boolean value) {
      this.requestField("level", value);
      return this;
    }
    public APIRequestGet requestSeparatorField () {
      return this.requestSeparatorField(true);
    }
    public APIRequestGet requestSeparatorField (boolean value) {
      this.requestField("separator", value);
      return this;
    }
    public APIRequestGet requestTemplateVersionField () {
      return this.requestTemplateVersionField(true);
    }
    public APIRequestGet requestTemplateVersionField (boolean value) {
      this.requestField("template_version", value);
      return this;
    }
    public APIRequestGet requestUserDefinedFieldsField () {
      return this.requestUserDefinedFieldsField(true);
    }
    public APIRequestGet requestUserDefinedFieldsField (boolean value) {
      this.requestField("user_defined_fields", value);
      return this;
    }
    public APIRequestGet requestValueSeparatorField () {
      return this.requestValueSeparatorField(true);
    }
    public APIRequestGet requestValueSeparatorField (boolean value) {
      this.requestField("value_separator", value);
      return this;
    }
  }

  public static enum EnumLevel {
      @SerializedName("ADGROUP")
      VALUE_ADGROUP("ADGROUP"),
      @SerializedName("AD_ACCOUNT")
      VALUE_AD_ACCOUNT("AD_ACCOUNT"),
      @SerializedName("CAMPAIGN")
      VALUE_CAMPAIGN("CAMPAIGN"),
      @SerializedName("CAMPAIGN_GROUP")
      VALUE_CAMPAIGN_GROUP("CAMPAIGN_GROUP"),
      @SerializedName("OPPORTUNITIES")
      VALUE_OPPORTUNITIES("OPPORTUNITIES"),
      @SerializedName("PRIVACY_INFO_CENTER")
      VALUE_PRIVACY_INFO_CENTER("PRIVACY_INFO_CENTER"),
      @SerializedName("PRODUCT")
      VALUE_PRODUCT("PRODUCT"),
      @SerializedName("TOPLINE")
      VALUE_TOPLINE("TOPLINE"),
      @SerializedName("UNIQUE_ADCREATIVE")
      VALUE_UNIQUE_ADCREATIVE("UNIQUE_ADCREATIVE"),
      ;

      private String value;

      private EnumLevel(String value) {
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

  public AdsNamingTemplate copyFrom(AdsNamingTemplate instance) {
    this.mApiFields = instance.mApiFields;
    this.mApiVersion = instance.mApiVersion;
    this.mFieldOrder = instance.mFieldOrder;
    this.mId = instance.mId;
    this.mLevel = instance.mLevel;
    this.mSeparator = instance.mSeparator;
    this.mTemplateVersion = instance.mTemplateVersion;
    this.mUserDefinedFields = instance.mUserDefinedFields;
    this.mValueSeparator = instance.mValueSeparator;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsNamingTemplate> getParser() {
    return new APIRequest.ResponseParser<AdsNamingTemplate>() {
      public APINodeList<AdsNamingTemplate> parseResponse(String response, APIContext context, APIRequest<AdsNamingTemplate> request, String header) throws MalformedResponseException {
        return AdsNamingTemplate.parseResponse(response, context, request, header);
      }
    };
  }
}
