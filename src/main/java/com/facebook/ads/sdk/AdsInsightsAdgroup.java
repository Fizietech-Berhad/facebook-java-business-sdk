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
public class AdsInsightsAdgroup extends APINode {
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public AdsInsightsAdgroup() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdsInsightsAdgroup loadJSON(String json, APIContext context, String header) {
    AdsInsightsAdgroup adsInsightsAdgroup = getGson().fromJson(json, AdsInsightsAdgroup.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsInsightsAdgroup.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsInsightsAdgroup.context = context;
    adsInsightsAdgroup.rawValue = json;
    adsInsightsAdgroup.header = header;
    return adsInsightsAdgroup;
  }

  public static APINodeList<AdsInsightsAdgroup> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsInsightsAdgroup> adsInsightsAdgroups = new APINodeList<AdsInsightsAdgroup>(request, json, header);
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
          adsInsightsAdgroups.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsInsightsAdgroups;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsInsightsAdgroups.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsInsightsAdgroups.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsInsightsAdgroups.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsInsightsAdgroups.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsInsightsAdgroups.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsInsightsAdgroups.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsInsightsAdgroups;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsInsightsAdgroups.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsInsightsAdgroups;
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
              adsInsightsAdgroups.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsInsightsAdgroups;
          }

          // Sixth, check if it's pure JsonObject
          adsInsightsAdgroups.clear();
          adsInsightsAdgroups.add(loadJSON(json, context, header));
          return adsInsightsAdgroups;
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

  public AdsInsightsAdgroup setFieldId(String value) {
    this.mId = value;
    return this;
  }



  public static class APIRequestGenget extends APIRequest<AdsInsightsAdgroupGet> {

    APINodeList<AdsInsightsAdgroupGet> lastResponse = null;
    @Override
    public APINodeList<AdsInsightsAdgroupGet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "after",
      "am_call_tags",
      "before",
      "breakdowns",
      "comparison_fields",
      "comparison_time_ranges",
      "date_preset",
      "debug_enable_trace",
      "default_attribution_windows",
      "default_summary",
      "e2e_scenario_run_id",
      "export_columns",
      "export_format",
      "export_name",
      "fields",
      "filtering",
      "flog",
      "graph_cache",
      "include_zeros",
      "level",
      "limit",
      "meta_breakdowns",
      "product_id_limit",
      "round_up_level",
      "run_id",
      "saber_setsuna_perf_request_id",
      "sort",
      "summary",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
      "use_account_attribution_setting",
      "use_unified_attribution_setting",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<AdsInsightsAdgroupGet> parseResponse(String response, String header) throws APIException {
      return AdsInsightsAdgroupGet.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdsInsightsAdgroupGet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsInsightsAdgroupGet> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsInsightsAdgroupGet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsInsightsAdgroupGet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdsInsightsAdgroupGet>>() {
           public APINodeList<AdsInsightsAdgroupGet> apply(ResponseWrapper result) {
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
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
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


    public APIRequestGenget setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGenget setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGenget setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGenget setAfter (String after) {
      this.setParam("after", after);
      return this;
    }

    public APIRequestGenget setAmCallTags (String amCallTags) {
      this.setParam("am_call_tags", amCallTags);
      return this;
    }

    public APIRequestGenget setBefore (String before) {
      this.setParam("before", before);
      return this;
    }

    public APIRequestGenget setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGenget setComparisonFields (String comparisonFields) {
      this.setParam("comparison_fields", comparisonFields);
      return this;
    }

    public APIRequestGenget setComparisonTimeRanges (String comparisonTimeRanges) {
      this.setParam("comparison_time_ranges", comparisonTimeRanges);
      return this;
    }

    public APIRequestGenget setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGenget setDebugEnableTrace (Boolean debugEnableTrace) {
      this.setParam("debug_enable_trace", debugEnableTrace);
      return this;
    }
    public APIRequestGenget setDebugEnableTrace (String debugEnableTrace) {
      this.setParam("debug_enable_trace", debugEnableTrace);
      return this;
    }

    public APIRequestGenget setDefaultAttributionWindows (String defaultAttributionWindows) {
      this.setParam("default_attribution_windows", defaultAttributionWindows);
      return this;
    }

    public APIRequestGenget setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }
    public APIRequestGenget setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGenget setE2eScenarioRunId (String e2eScenarioRunId) {
      this.setParam("e2e_scenario_run_id", e2eScenarioRunId);
      return this;
    }

    public APIRequestGenget setExportColumns (String exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }

    public APIRequestGenget setExportFormat (String exportFormat) {
      this.setParam("export_format", exportFormat);
      return this;
    }

    public APIRequestGenget setExportName (String exportName) {
      this.setParam("export_name", exportName);
      return this;
    }

    public APIRequestGenget setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGenget setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGenget setFlog (String flog) {
      this.setParam("flog", flog);
      return this;
    }

    public APIRequestGenget setGraphCache (Boolean graphCache) {
      this.setParam("graph_cache", graphCache);
      return this;
    }
    public APIRequestGenget setGraphCache (String graphCache) {
      this.setParam("graph_cache", graphCache);
      return this;
    }

    public APIRequestGenget setIncludeZeros (Boolean includeZeros) {
      this.setParam("include_zeros", includeZeros);
      return this;
    }
    public APIRequestGenget setIncludeZeros (String includeZeros) {
      this.setParam("include_zeros", includeZeros);
      return this;
    }

    public APIRequestGenget setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGenget setLimit (Long limit) {
      this.setParam("limit", limit);
      return this;
    }
    public APIRequestGenget setLimit (String limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGenget setMetaBreakdowns (String metaBreakdowns) {
      this.setParam("meta_breakdowns", metaBreakdowns);
      return this;
    }

    public APIRequestGenget setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }
    public APIRequestGenget setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGenget setRoundUpLevel (String roundUpLevel) {
      this.setParam("round_up_level", roundUpLevel);
      return this;
    }

    public APIRequestGenget setRunId (String runId) {
      this.setParam("run_id", runId);
      return this;
    }

    public APIRequestGenget setSaberSetsunaPerfRequestId (String saberSetsunaPerfRequestId) {
      this.setParam("saber_setsuna_perf_request_id", saberSetsunaPerfRequestId);
      return this;
    }

    public APIRequestGenget setSort (String sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGenget setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGenget setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGenget setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestGenget setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGenget setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGenget setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGenget setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGenget setUseUnifiedAttributionSetting (Boolean useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
      return this;
    }
    public APIRequestGenget setUseUnifiedAttributionSetting (String useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
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

  public AdsInsightsAdgroup copyFrom(AdsInsightsAdgroup instance) {
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsInsightsAdgroup> getParser() {
    return new APIRequest.ResponseParser<AdsInsightsAdgroup>() {
      public APINodeList<AdsInsightsAdgroup> parseResponse(String response, APIContext context, APIRequest<AdsInsightsAdgroup> request, String header) throws MalformedResponseException {
        return AdsInsightsAdgroup.parseResponse(response, context, request, header);
      }
    };
  }
}
