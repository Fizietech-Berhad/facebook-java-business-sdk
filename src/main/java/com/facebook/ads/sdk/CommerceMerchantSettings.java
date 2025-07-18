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
public class CommerceMerchantSettings extends APINode {
  @SerializedName("checkout_config")
  private String mCheckoutConfig = null;
  @SerializedName("checkout_message")
  private String mCheckoutMessage = null;
  @SerializedName("contact_email")
  private String mContactEmail = null;
  @SerializedName("cta")
  private String mCta = null;
  @SerializedName("display_name")
  private String mDisplayName = null;
  @SerializedName("facebook_channel")
  private Object mFacebookChannel = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("instagram_channel")
  private Object mInstagramChannel = null;
  @SerializedName("korea_ftc_listing")
  private String mKoreaFtcListing = null;
  @SerializedName("merchant_page")
  private Profile mMerchantPage = null;
  @SerializedName("merchant_status")
  private String mMerchantStatus = null;
  @SerializedName("offsite_iab_checkout_enabled_countries")
  private List<String> mOffsiteIabCheckoutEnabledCountries = null;
  @SerializedName("onsite_commerce_merchant")
  private Object mOnsiteCommerceMerchant = null;
  @SerializedName("payment_provider")
  private String mPaymentProvider = null;
  @SerializedName("privacy_policy_localized")
  private String mPrivacyPolicyLocalized = null;
  @SerializedName("return_policy_localized")
  private String mReturnPolicyLocalized = null;
  @SerializedName("review_rejection_messages")
  private List<String> mReviewRejectionMessages = null;
  @SerializedName("review_rejection_reasons")
  private List<String> mReviewRejectionReasons = null;
  @SerializedName("shops_ads_setup")
  private Object mShopsAdsSetup = null;
  @SerializedName("terms")
  private String mTerms = null;
  protected static Gson gson = null;

  CommerceMerchantSettings() {
  }

  public CommerceMerchantSettings(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CommerceMerchantSettings(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CommerceMerchantSettings fetch() throws APIException{
    CommerceMerchantSettings newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CommerceMerchantSettings fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CommerceMerchantSettings> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CommerceMerchantSettings fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CommerceMerchantSettings> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CommerceMerchantSettings> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CommerceMerchantSettings>)(
      new APIRequest<CommerceMerchantSettings>(context, "", "/", "GET", CommerceMerchantSettings.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CommerceMerchantSettings>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CommerceMerchantSettings.getParser())
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
  public static CommerceMerchantSettings loadJSON(String json, APIContext context, String header) {
    CommerceMerchantSettings commerceMerchantSettings = getGson().fromJson(json, CommerceMerchantSettings.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(commerceMerchantSettings.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    commerceMerchantSettings.context = context;
    commerceMerchantSettings.rawValue = json;
    commerceMerchantSettings.header = header;
    return commerceMerchantSettings;
  }

  public static APINodeList<CommerceMerchantSettings> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CommerceMerchantSettings> commerceMerchantSettingss = new APINodeList<CommerceMerchantSettings>(request, json, header);
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
          commerceMerchantSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return commerceMerchantSettingss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                commerceMerchantSettingss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            commerceMerchantSettingss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              commerceMerchantSettingss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              commerceMerchantSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  commerceMerchantSettingss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              commerceMerchantSettingss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return commerceMerchantSettingss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              commerceMerchantSettingss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return commerceMerchantSettingss;
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
              commerceMerchantSettingss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return commerceMerchantSettingss;
          }

          // Sixth, check if it's pure JsonObject
          commerceMerchantSettingss.clear();
          commerceMerchantSettingss.add(loadJSON(json, context, header));
          return commerceMerchantSettingss;
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

  public APIRequestCreateAcknowledgeOrder createAcknowledgeOrder() {
    return new APIRequestCreateAcknowledgeOrder(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCommerceOrders getCommerceOrders() {
    return new APIRequestGetCommerceOrders(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCommercePayouts getCommercePayouts() {
    return new APIRequestGetCommercePayouts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCommerceTransactions getCommerceTransactions() {
    return new APIRequestGetCommerceTransactions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOrderManagementApps getOrderManagementApps() {
    return new APIRequestGetOrderManagementApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOrderManagementApp createOrderManagementApp() {
    return new APIRequestCreateOrderManagementApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductCatalogs getProductCatalogs() {
    return new APIRequestGetProductCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReturns getReturns() {
    return new APIRequestGetReturns(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSetupStatus getSetupStatus() {
    return new APIRequestGetSetupStatus(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetShippingProfiles getShippingProfiles() {
    return new APIRequestGetShippingProfiles(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateShippingProfile createShippingProfile() {
    return new APIRequestCreateShippingProfile(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetShops getShops() {
    return new APIRequestGetShops(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTaxSettings getTaxSettings() {
    return new APIRequestGetTaxSettings(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldCheckoutConfig() {
    return mCheckoutConfig;
  }

  public String getFieldCheckoutMessage() {
    return mCheckoutMessage;
  }

  public String getFieldContactEmail() {
    return mContactEmail;
  }

  public String getFieldCta() {
    return mCta;
  }

  public String getFieldDisplayName() {
    return mDisplayName;
  }

  public Object getFieldFacebookChannel() {
    return mFacebookChannel;
  }

  public String getFieldId() {
    return mId;
  }

  public Object getFieldInstagramChannel() {
    return mInstagramChannel;
  }

  public String getFieldKoreaFtcListing() {
    return mKoreaFtcListing;
  }

  public Profile getFieldMerchantPage() {
    if (mMerchantPage != null) {
      mMerchantPage.context = getContext();
    }
    return mMerchantPage;
  }

  public String getFieldMerchantStatus() {
    return mMerchantStatus;
  }

  public List<String> getFieldOffsiteIabCheckoutEnabledCountries() {
    return mOffsiteIabCheckoutEnabledCountries;
  }

  public Object getFieldOnsiteCommerceMerchant() {
    return mOnsiteCommerceMerchant;
  }

  public String getFieldPaymentProvider() {
    return mPaymentProvider;
  }

  public String getFieldPrivacyPolicyLocalized() {
    return mPrivacyPolicyLocalized;
  }

  public String getFieldReturnPolicyLocalized() {
    return mReturnPolicyLocalized;
  }

  public List<String> getFieldReviewRejectionMessages() {
    return mReviewRejectionMessages;
  }

  public List<String> getFieldReviewRejectionReasons() {
    return mReviewRejectionReasons;
  }

  public Object getFieldShopsAdsSetup() {
    return mShopsAdsSetup;
  }

  public String getFieldTerms() {
    return mTerms;
  }



  public static class APIRequestCreateAcknowledgeOrder extends APIRequest<CommerceMerchantSettings> {

    CommerceMerchantSettings lastResponse = null;
    @Override
    public CommerceMerchantSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "idempotency_key",
      "orders",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CommerceMerchantSettings parseResponse(String response, String header) throws APIException {
      return CommerceMerchantSettings.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceMerchantSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceMerchantSettings execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceMerchantSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceMerchantSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceMerchantSettings>() {
           public CommerceMerchantSettings apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAcknowledgeOrder.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAcknowledgeOrder(String nodeId, APIContext context) {
      super(context, nodeId, "/acknowledge_orders", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAcknowledgeOrder setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAcknowledgeOrder setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAcknowledgeOrder setIdempotencyKey (String idempotencyKey) {
      this.setParam("idempotency_key", idempotencyKey);
      return this;
    }

    public APIRequestCreateAcknowledgeOrder setOrders (List<Map<String, String>> orders) {
      this.setParam("orders", orders);
      return this;
    }
    public APIRequestCreateAcknowledgeOrder setOrders (String orders) {
      this.setParam("orders", orders);
      return this;
    }

    public APIRequestCreateAcknowledgeOrder requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAcknowledgeOrder requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAcknowledgeOrder requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAcknowledgeOrder requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAcknowledgeOrder requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAcknowledgeOrder requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCommerceOrders extends APIRequest<CommerceOrder> {

    APINodeList<CommerceOrder> lastResponse = null;
    @Override
    public APINodeList<CommerceOrder> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filters",
      "state",
      "updated_after",
      "updated_before",
    };

    public static final String[] FIELDS = {
      "buyer_details",
      "channel",
      "contains_bopis_items",
      "created",
      "estimated_payment_details",
      "id",
      "is_group_buy",
      "is_test_order",
      "last_updated",
      "merchant_order_id",
      "order_status",
      "pre_order_details",
      "selected_shipping_option",
      "ship_by_date",
      "shipping_address",
    };

    @Override
    public APINodeList<CommerceOrder> parseResponse(String response, String header) throws APIException {
      return CommerceOrder.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CommerceOrder> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CommerceOrder> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CommerceOrder>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CommerceOrder>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CommerceOrder>>() {
           public APINodeList<CommerceOrder> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCommerceOrders.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCommerceOrders(String nodeId, APIContext context) {
      super(context, nodeId, "/commerce_orders", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCommerceOrders setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCommerceOrders setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCommerceOrders setFilters (List<CommerceOrder.EnumFilters> filters) {
      this.setParam("filters", filters);
      return this;
    }
    public APIRequestGetCommerceOrders setFilters (String filters) {
      this.setParam("filters", filters);
      return this;
    }

    public APIRequestGetCommerceOrders setState (List<CommerceOrder.EnumState> state) {
      this.setParam("state", state);
      return this;
    }
    public APIRequestGetCommerceOrders setState (String state) {
      this.setParam("state", state);
      return this;
    }

    public APIRequestGetCommerceOrders setUpdatedAfter (String updatedAfter) {
      this.setParam("updated_after", updatedAfter);
      return this;
    }

    public APIRequestGetCommerceOrders setUpdatedBefore (String updatedBefore) {
      this.setParam("updated_before", updatedBefore);
      return this;
    }

    public APIRequestGetCommerceOrders requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCommerceOrders requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCommerceOrders requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCommerceOrders requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCommerceOrders requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCommerceOrders requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCommerceOrders requestBuyerDetailsField () {
      return this.requestBuyerDetailsField(true);
    }
    public APIRequestGetCommerceOrders requestBuyerDetailsField (boolean value) {
      this.requestField("buyer_details", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestChannelField () {
      return this.requestChannelField(true);
    }
    public APIRequestGetCommerceOrders requestChannelField (boolean value) {
      this.requestField("channel", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestContainsBopisItemsField () {
      return this.requestContainsBopisItemsField(true);
    }
    public APIRequestGetCommerceOrders requestContainsBopisItemsField (boolean value) {
      this.requestField("contains_bopis_items", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestCreatedField () {
      return this.requestCreatedField(true);
    }
    public APIRequestGetCommerceOrders requestCreatedField (boolean value) {
      this.requestField("created", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestEstimatedPaymentDetailsField () {
      return this.requestEstimatedPaymentDetailsField(true);
    }
    public APIRequestGetCommerceOrders requestEstimatedPaymentDetailsField (boolean value) {
      this.requestField("estimated_payment_details", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCommerceOrders requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestIsGroupBuyField () {
      return this.requestIsGroupBuyField(true);
    }
    public APIRequestGetCommerceOrders requestIsGroupBuyField (boolean value) {
      this.requestField("is_group_buy", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestIsTestOrderField () {
      return this.requestIsTestOrderField(true);
    }
    public APIRequestGetCommerceOrders requestIsTestOrderField (boolean value) {
      this.requestField("is_test_order", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestLastUpdatedField () {
      return this.requestLastUpdatedField(true);
    }
    public APIRequestGetCommerceOrders requestLastUpdatedField (boolean value) {
      this.requestField("last_updated", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestMerchantOrderIdField () {
      return this.requestMerchantOrderIdField(true);
    }
    public APIRequestGetCommerceOrders requestMerchantOrderIdField (boolean value) {
      this.requestField("merchant_order_id", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestOrderStatusField () {
      return this.requestOrderStatusField(true);
    }
    public APIRequestGetCommerceOrders requestOrderStatusField (boolean value) {
      this.requestField("order_status", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestPreOrderDetailsField () {
      return this.requestPreOrderDetailsField(true);
    }
    public APIRequestGetCommerceOrders requestPreOrderDetailsField (boolean value) {
      this.requestField("pre_order_details", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestSelectedShippingOptionField () {
      return this.requestSelectedShippingOptionField(true);
    }
    public APIRequestGetCommerceOrders requestSelectedShippingOptionField (boolean value) {
      this.requestField("selected_shipping_option", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestShipByDateField () {
      return this.requestShipByDateField(true);
    }
    public APIRequestGetCommerceOrders requestShipByDateField (boolean value) {
      this.requestField("ship_by_date", value);
      return this;
    }
    public APIRequestGetCommerceOrders requestShippingAddressField () {
      return this.requestShippingAddressField(true);
    }
    public APIRequestGetCommerceOrders requestShippingAddressField (boolean value) {
      this.requestField("shipping_address", value);
      return this;
    }
  }

  public static class APIRequestGetCommercePayouts extends APIRequest<CommercePayout> {

    APINodeList<CommercePayout> lastResponse = null;
    @Override
    public APINodeList<CommercePayout> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_time",
      "start_time",
    };

    public static final String[] FIELDS = {
      "amount",
      "payout_date",
      "payout_reference_id",
      "status",
      "transfer_id",
    };

    @Override
    public APINodeList<CommercePayout> parseResponse(String response, String header) throws APIException {
      return CommercePayout.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CommercePayout> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CommercePayout> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CommercePayout>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CommercePayout>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CommercePayout>>() {
           public APINodeList<CommercePayout> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCommercePayouts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCommercePayouts(String nodeId, APIContext context) {
      super(context, nodeId, "/commerce_payouts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCommercePayouts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCommercePayouts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCommercePayouts setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestGetCommercePayouts setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestGetCommercePayouts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCommercePayouts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCommercePayouts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCommercePayouts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCommercePayouts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCommercePayouts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCommercePayouts requestAmountField () {
      return this.requestAmountField(true);
    }
    public APIRequestGetCommercePayouts requestAmountField (boolean value) {
      this.requestField("amount", value);
      return this;
    }
    public APIRequestGetCommercePayouts requestPayoutDateField () {
      return this.requestPayoutDateField(true);
    }
    public APIRequestGetCommercePayouts requestPayoutDateField (boolean value) {
      this.requestField("payout_date", value);
      return this;
    }
    public APIRequestGetCommercePayouts requestPayoutReferenceIdField () {
      return this.requestPayoutReferenceIdField(true);
    }
    public APIRequestGetCommercePayouts requestPayoutReferenceIdField (boolean value) {
      this.requestField("payout_reference_id", value);
      return this;
    }
    public APIRequestGetCommercePayouts requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCommercePayouts requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCommercePayouts requestTransferIdField () {
      return this.requestTransferIdField(true);
    }
    public APIRequestGetCommercePayouts requestTransferIdField (boolean value) {
      this.requestField("transfer_id", value);
      return this;
    }
  }

  public static class APIRequestGetCommerceTransactions extends APIRequest<CommerceOrderTransactionDetail> {

    APINodeList<CommerceOrderTransactionDetail> lastResponse = null;
    @Override
    public APINodeList<CommerceOrderTransactionDetail> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_time",
      "payout_reference_id",
      "start_time",
    };

    public static final String[] FIELDS = {
      "merchant_order_id",
      "net_payment_amount",
      "order_created",
      "order_details",
      "order_id",
      "payout_reference_id",
      "postal_code",
      "processing_fee",
      "state",
      "tax_rate",
      "transaction_date",
      "transaction_type",
      "transfer_id",
      "id",
    };

    @Override
    public APINodeList<CommerceOrderTransactionDetail> parseResponse(String response, String header) throws APIException {
      return CommerceOrderTransactionDetail.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CommerceOrderTransactionDetail> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CommerceOrderTransactionDetail> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CommerceOrderTransactionDetail>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CommerceOrderTransactionDetail>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CommerceOrderTransactionDetail>>() {
           public APINodeList<CommerceOrderTransactionDetail> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCommerceTransactions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCommerceTransactions(String nodeId, APIContext context) {
      super(context, nodeId, "/commerce_transactions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCommerceTransactions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCommerceTransactions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCommerceTransactions setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestGetCommerceTransactions setPayoutReferenceId (String payoutReferenceId) {
      this.setParam("payout_reference_id", payoutReferenceId);
      return this;
    }

    public APIRequestGetCommerceTransactions setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestGetCommerceTransactions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCommerceTransactions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCommerceTransactions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCommerceTransactions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCommerceTransactions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCommerceTransactions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCommerceTransactions requestMerchantOrderIdField () {
      return this.requestMerchantOrderIdField(true);
    }
    public APIRequestGetCommerceTransactions requestMerchantOrderIdField (boolean value) {
      this.requestField("merchant_order_id", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestNetPaymentAmountField () {
      return this.requestNetPaymentAmountField(true);
    }
    public APIRequestGetCommerceTransactions requestNetPaymentAmountField (boolean value) {
      this.requestField("net_payment_amount", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestOrderCreatedField () {
      return this.requestOrderCreatedField(true);
    }
    public APIRequestGetCommerceTransactions requestOrderCreatedField (boolean value) {
      this.requestField("order_created", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestOrderDetailsField () {
      return this.requestOrderDetailsField(true);
    }
    public APIRequestGetCommerceTransactions requestOrderDetailsField (boolean value) {
      this.requestField("order_details", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestOrderIdField () {
      return this.requestOrderIdField(true);
    }
    public APIRequestGetCommerceTransactions requestOrderIdField (boolean value) {
      this.requestField("order_id", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestPayoutReferenceIdField () {
      return this.requestPayoutReferenceIdField(true);
    }
    public APIRequestGetCommerceTransactions requestPayoutReferenceIdField (boolean value) {
      this.requestField("payout_reference_id", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestPostalCodeField () {
      return this.requestPostalCodeField(true);
    }
    public APIRequestGetCommerceTransactions requestPostalCodeField (boolean value) {
      this.requestField("postal_code", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestProcessingFeeField () {
      return this.requestProcessingFeeField(true);
    }
    public APIRequestGetCommerceTransactions requestProcessingFeeField (boolean value) {
      this.requestField("processing_fee", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestStateField () {
      return this.requestStateField(true);
    }
    public APIRequestGetCommerceTransactions requestStateField (boolean value) {
      this.requestField("state", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestTaxRateField () {
      return this.requestTaxRateField(true);
    }
    public APIRequestGetCommerceTransactions requestTaxRateField (boolean value) {
      this.requestField("tax_rate", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestTransactionDateField () {
      return this.requestTransactionDateField(true);
    }
    public APIRequestGetCommerceTransactions requestTransactionDateField (boolean value) {
      this.requestField("transaction_date", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestTransactionTypeField () {
      return this.requestTransactionTypeField(true);
    }
    public APIRequestGetCommerceTransactions requestTransactionTypeField (boolean value) {
      this.requestField("transaction_type", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestTransferIdField () {
      return this.requestTransferIdField(true);
    }
    public APIRequestGetCommerceTransactions requestTransferIdField (boolean value) {
      this.requestField("transfer_id", value);
      return this;
    }
    public APIRequestGetCommerceTransactions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCommerceTransactions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetOrderManagementApps extends APIRequest<Application> {

    APINodeList<Application> lastResponse = null;
    @Override
    public APINodeList<Application> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "aam_rules",
      "an_ad_space_limit",
      "an_platforms",
      "android_key_hash",
      "android_sdk_error_categories",
      "app_domains",
      "app_events_config",
      "app_events_feature_bitmask",
      "app_events_session_timeout",
      "app_install_tracked",
      "app_name",
      "app_signals_binding_ios",
      "app_type",
      "auth_dialog_data_help_url",
      "auth_dialog_headline",
      "auth_dialog_perms_explanation",
      "auth_referral_default_activity_privacy",
      "auth_referral_enabled",
      "auth_referral_extended_perms",
      "auth_referral_friend_perms",
      "auth_referral_response_type",
      "auth_referral_user_perms",
      "auto_event_mapping_android",
      "auto_event_mapping_ios",
      "auto_event_setup_enabled",
      "auto_log_app_events_default",
      "auto_log_app_events_enabled",
      "business",
      "canvas_fluid_height",
      "canvas_fluid_width",
      "canvas_url",
      "category",
      "client_config",
      "company",
      "configured_ios_sso",
      "contact_email",
      "created_time",
      "creator_uid",
      "daily_active_users",
      "daily_active_users_rank",
      "deauth_callback_url",
      "default_share_mode",
      "description",
      "enigma_config",
      "financial_id",
      "gdpv4_chrome_custom_tabs_enabled",
      "gdpv4_enabled",
      "gdpv4_nux_content",
      "gdpv4_nux_enabled",
      "has_messenger_product",
      "hosting_url",
      "icon_url",
      "id",
      "ios_bundle_id",
      "ios_sdk_dialog_flows",
      "ios_sdk_error_categories",
      "ios_sfvc_attr",
      "ios_supports_native_proxy_auth_flow",
      "ios_supports_system_auth",
      "ipad_app_store_id",
      "iphone_app_store_id",
      "latest_sdk_version",
      "link",
      "logging_token",
      "logo_url",
      "migrations",
      "mobile_profile_section_url",
      "mobile_web_url",
      "monthly_active_users",
      "monthly_active_users_rank",
      "name",
      "namespace",
      "object_store_urls",
      "owner_business",
      "page_tab_default_name",
      "page_tab_url",
      "photo_url",
      "privacy_policy_url",
      "profile_section_url",
      "property_id",
      "protected_mode_rules",
      "real_time_mode_devices",
      "restrictions",
      "restrictive_data_filter_params",
      "restrictive_data_filter_rules",
      "sdk_update_message",
      "seamless_login",
      "secure_canvas_url",
      "secure_page_tab_url",
      "server_ip_whitelist",
      "smart_login_bookmark_icon_url",
      "smart_login_menu_icon_url",
      "social_discovery",
      "subcategory",
      "suggested_events_setting",
      "supported_platforms",
      "supports_apprequests_fast_app_switch",
      "supports_attribution",
      "supports_implicit_sdk_logging",
      "suppress_native_ios_gdp",
      "terms_of_service_url",
      "url_scheme_suffix",
      "user_support_email",
      "user_support_url",
      "website_url",
      "weekly_active_users",
    };

    @Override
    public APINodeList<Application> parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Application> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Application> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Application>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Application>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Application>>() {
           public APINodeList<Application> apply(ResponseWrapper result) {
             try {
               return APIRequestGetOrderManagementApps.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOrderManagementApps(String nodeId, APIContext context) {
      super(context, nodeId, "/order_management_apps", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOrderManagementApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOrderManagementApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOrderManagementApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOrderManagementApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOrderManagementApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOrderManagementApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOrderManagementApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOrderManagementApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOrderManagementApps requestAamRulesField () {
      return this.requestAamRulesField(true);
    }
    public APIRequestGetOrderManagementApps requestAamRulesField (boolean value) {
      this.requestField("aam_rules", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAnAdSpaceLimitField () {
      return this.requestAnAdSpaceLimitField(true);
    }
    public APIRequestGetOrderManagementApps requestAnAdSpaceLimitField (boolean value) {
      this.requestField("an_ad_space_limit", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAnPlatformsField () {
      return this.requestAnPlatformsField(true);
    }
    public APIRequestGetOrderManagementApps requestAnPlatformsField (boolean value) {
      this.requestField("an_platforms", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAndroidKeyHashField () {
      return this.requestAndroidKeyHashField(true);
    }
    public APIRequestGetOrderManagementApps requestAndroidKeyHashField (boolean value) {
      this.requestField("android_key_hash", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAndroidSdkErrorCategoriesField () {
      return this.requestAndroidSdkErrorCategoriesField(true);
    }
    public APIRequestGetOrderManagementApps requestAndroidSdkErrorCategoriesField (boolean value) {
      this.requestField("android_sdk_error_categories", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAppDomainsField () {
      return this.requestAppDomainsField(true);
    }
    public APIRequestGetOrderManagementApps requestAppDomainsField (boolean value) {
      this.requestField("app_domains", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAppEventsConfigField () {
      return this.requestAppEventsConfigField(true);
    }
    public APIRequestGetOrderManagementApps requestAppEventsConfigField (boolean value) {
      this.requestField("app_events_config", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAppEventsFeatureBitmaskField () {
      return this.requestAppEventsFeatureBitmaskField(true);
    }
    public APIRequestGetOrderManagementApps requestAppEventsFeatureBitmaskField (boolean value) {
      this.requestField("app_events_feature_bitmask", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAppEventsSessionTimeoutField () {
      return this.requestAppEventsSessionTimeoutField(true);
    }
    public APIRequestGetOrderManagementApps requestAppEventsSessionTimeoutField (boolean value) {
      this.requestField("app_events_session_timeout", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAppInstallTrackedField () {
      return this.requestAppInstallTrackedField(true);
    }
    public APIRequestGetOrderManagementApps requestAppInstallTrackedField (boolean value) {
      this.requestField("app_install_tracked", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAppNameField () {
      return this.requestAppNameField(true);
    }
    public APIRequestGetOrderManagementApps requestAppNameField (boolean value) {
      this.requestField("app_name", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAppSignalsBindingIosField () {
      return this.requestAppSignalsBindingIosField(true);
    }
    public APIRequestGetOrderManagementApps requestAppSignalsBindingIosField (boolean value) {
      this.requestField("app_signals_binding_ios", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAppTypeField () {
      return this.requestAppTypeField(true);
    }
    public APIRequestGetOrderManagementApps requestAppTypeField (boolean value) {
      this.requestField("app_type", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAuthDialogDataHelpUrlField () {
      return this.requestAuthDialogDataHelpUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestAuthDialogDataHelpUrlField (boolean value) {
      this.requestField("auth_dialog_data_help_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAuthDialogHeadlineField () {
      return this.requestAuthDialogHeadlineField(true);
    }
    public APIRequestGetOrderManagementApps requestAuthDialogHeadlineField (boolean value) {
      this.requestField("auth_dialog_headline", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAuthDialogPermsExplanationField () {
      return this.requestAuthDialogPermsExplanationField(true);
    }
    public APIRequestGetOrderManagementApps requestAuthDialogPermsExplanationField (boolean value) {
      this.requestField("auth_dialog_perms_explanation", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAuthReferralDefaultActivityPrivacyField () {
      return this.requestAuthReferralDefaultActivityPrivacyField(true);
    }
    public APIRequestGetOrderManagementApps requestAuthReferralDefaultActivityPrivacyField (boolean value) {
      this.requestField("auth_referral_default_activity_privacy", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAuthReferralEnabledField () {
      return this.requestAuthReferralEnabledField(true);
    }
    public APIRequestGetOrderManagementApps requestAuthReferralEnabledField (boolean value) {
      this.requestField("auth_referral_enabled", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAuthReferralExtendedPermsField () {
      return this.requestAuthReferralExtendedPermsField(true);
    }
    public APIRequestGetOrderManagementApps requestAuthReferralExtendedPermsField (boolean value) {
      this.requestField("auth_referral_extended_perms", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAuthReferralFriendPermsField () {
      return this.requestAuthReferralFriendPermsField(true);
    }
    public APIRequestGetOrderManagementApps requestAuthReferralFriendPermsField (boolean value) {
      this.requestField("auth_referral_friend_perms", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAuthReferralResponseTypeField () {
      return this.requestAuthReferralResponseTypeField(true);
    }
    public APIRequestGetOrderManagementApps requestAuthReferralResponseTypeField (boolean value) {
      this.requestField("auth_referral_response_type", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAuthReferralUserPermsField () {
      return this.requestAuthReferralUserPermsField(true);
    }
    public APIRequestGetOrderManagementApps requestAuthReferralUserPermsField (boolean value) {
      this.requestField("auth_referral_user_perms", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAutoEventMappingAndroidField () {
      return this.requestAutoEventMappingAndroidField(true);
    }
    public APIRequestGetOrderManagementApps requestAutoEventMappingAndroidField (boolean value) {
      this.requestField("auto_event_mapping_android", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAutoEventMappingIosField () {
      return this.requestAutoEventMappingIosField(true);
    }
    public APIRequestGetOrderManagementApps requestAutoEventMappingIosField (boolean value) {
      this.requestField("auto_event_mapping_ios", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAutoEventSetupEnabledField () {
      return this.requestAutoEventSetupEnabledField(true);
    }
    public APIRequestGetOrderManagementApps requestAutoEventSetupEnabledField (boolean value) {
      this.requestField("auto_event_setup_enabled", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAutoLogAppEventsDefaultField () {
      return this.requestAutoLogAppEventsDefaultField(true);
    }
    public APIRequestGetOrderManagementApps requestAutoLogAppEventsDefaultField (boolean value) {
      this.requestField("auto_log_app_events_default", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestAutoLogAppEventsEnabledField () {
      return this.requestAutoLogAppEventsEnabledField(true);
    }
    public APIRequestGetOrderManagementApps requestAutoLogAppEventsEnabledField (boolean value) {
      this.requestField("auto_log_app_events_enabled", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOrderManagementApps requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestCanvasFluidHeightField () {
      return this.requestCanvasFluidHeightField(true);
    }
    public APIRequestGetOrderManagementApps requestCanvasFluidHeightField (boolean value) {
      this.requestField("canvas_fluid_height", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestCanvasFluidWidthField () {
      return this.requestCanvasFluidWidthField(true);
    }
    public APIRequestGetOrderManagementApps requestCanvasFluidWidthField (boolean value) {
      this.requestField("canvas_fluid_width", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestCanvasUrlField () {
      return this.requestCanvasUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestCanvasUrlField (boolean value) {
      this.requestField("canvas_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetOrderManagementApps requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestClientConfigField () {
      return this.requestClientConfigField(true);
    }
    public APIRequestGetOrderManagementApps requestClientConfigField (boolean value) {
      this.requestField("client_config", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestCompanyField () {
      return this.requestCompanyField(true);
    }
    public APIRequestGetOrderManagementApps requestCompanyField (boolean value) {
      this.requestField("company", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestConfiguredIosSsoField () {
      return this.requestConfiguredIosSsoField(true);
    }
    public APIRequestGetOrderManagementApps requestConfiguredIosSsoField (boolean value) {
      this.requestField("configured_ios_sso", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestContactEmailField () {
      return this.requestContactEmailField(true);
    }
    public APIRequestGetOrderManagementApps requestContactEmailField (boolean value) {
      this.requestField("contact_email", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetOrderManagementApps requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestCreatorUidField () {
      return this.requestCreatorUidField(true);
    }
    public APIRequestGetOrderManagementApps requestCreatorUidField (boolean value) {
      this.requestField("creator_uid", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestDailyActiveUsersField () {
      return this.requestDailyActiveUsersField(true);
    }
    public APIRequestGetOrderManagementApps requestDailyActiveUsersField (boolean value) {
      this.requestField("daily_active_users", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestDailyActiveUsersRankField () {
      return this.requestDailyActiveUsersRankField(true);
    }
    public APIRequestGetOrderManagementApps requestDailyActiveUsersRankField (boolean value) {
      this.requestField("daily_active_users_rank", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestDeauthCallbackUrlField () {
      return this.requestDeauthCallbackUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestDeauthCallbackUrlField (boolean value) {
      this.requestField("deauth_callback_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestDefaultShareModeField () {
      return this.requestDefaultShareModeField(true);
    }
    public APIRequestGetOrderManagementApps requestDefaultShareModeField (boolean value) {
      this.requestField("default_share_mode", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetOrderManagementApps requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestEnigmaConfigField () {
      return this.requestEnigmaConfigField(true);
    }
    public APIRequestGetOrderManagementApps requestEnigmaConfigField (boolean value) {
      this.requestField("enigma_config", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestFinancialIdField () {
      return this.requestFinancialIdField(true);
    }
    public APIRequestGetOrderManagementApps requestFinancialIdField (boolean value) {
      this.requestField("financial_id", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestGdpv4ChromeCustomTabsEnabledField () {
      return this.requestGdpv4ChromeCustomTabsEnabledField(true);
    }
    public APIRequestGetOrderManagementApps requestGdpv4ChromeCustomTabsEnabledField (boolean value) {
      this.requestField("gdpv4_chrome_custom_tabs_enabled", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestGdpv4EnabledField () {
      return this.requestGdpv4EnabledField(true);
    }
    public APIRequestGetOrderManagementApps requestGdpv4EnabledField (boolean value) {
      this.requestField("gdpv4_enabled", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestGdpv4NuxContentField () {
      return this.requestGdpv4NuxContentField(true);
    }
    public APIRequestGetOrderManagementApps requestGdpv4NuxContentField (boolean value) {
      this.requestField("gdpv4_nux_content", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestGdpv4NuxEnabledField () {
      return this.requestGdpv4NuxEnabledField(true);
    }
    public APIRequestGetOrderManagementApps requestGdpv4NuxEnabledField (boolean value) {
      this.requestField("gdpv4_nux_enabled", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestHasMessengerProductField () {
      return this.requestHasMessengerProductField(true);
    }
    public APIRequestGetOrderManagementApps requestHasMessengerProductField (boolean value) {
      this.requestField("has_messenger_product", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestHostingUrlField () {
      return this.requestHostingUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestHostingUrlField (boolean value) {
      this.requestField("hosting_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOrderManagementApps requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestIosBundleIdField () {
      return this.requestIosBundleIdField(true);
    }
    public APIRequestGetOrderManagementApps requestIosBundleIdField (boolean value) {
      this.requestField("ios_bundle_id", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestIosSdkDialogFlowsField () {
      return this.requestIosSdkDialogFlowsField(true);
    }
    public APIRequestGetOrderManagementApps requestIosSdkDialogFlowsField (boolean value) {
      this.requestField("ios_sdk_dialog_flows", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestIosSdkErrorCategoriesField () {
      return this.requestIosSdkErrorCategoriesField(true);
    }
    public APIRequestGetOrderManagementApps requestIosSdkErrorCategoriesField (boolean value) {
      this.requestField("ios_sdk_error_categories", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestIosSfvcAttrField () {
      return this.requestIosSfvcAttrField(true);
    }
    public APIRequestGetOrderManagementApps requestIosSfvcAttrField (boolean value) {
      this.requestField("ios_sfvc_attr", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestIosSupportsNativeProxyAuthFlowField () {
      return this.requestIosSupportsNativeProxyAuthFlowField(true);
    }
    public APIRequestGetOrderManagementApps requestIosSupportsNativeProxyAuthFlowField (boolean value) {
      this.requestField("ios_supports_native_proxy_auth_flow", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestIosSupportsSystemAuthField () {
      return this.requestIosSupportsSystemAuthField(true);
    }
    public APIRequestGetOrderManagementApps requestIosSupportsSystemAuthField (boolean value) {
      this.requestField("ios_supports_system_auth", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestIpadAppStoreIdField () {
      return this.requestIpadAppStoreIdField(true);
    }
    public APIRequestGetOrderManagementApps requestIpadAppStoreIdField (boolean value) {
      this.requestField("ipad_app_store_id", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestIphoneAppStoreIdField () {
      return this.requestIphoneAppStoreIdField(true);
    }
    public APIRequestGetOrderManagementApps requestIphoneAppStoreIdField (boolean value) {
      this.requestField("iphone_app_store_id", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestLatestSdkVersionField () {
      return this.requestLatestSdkVersionField(true);
    }
    public APIRequestGetOrderManagementApps requestLatestSdkVersionField (boolean value) {
      this.requestField("latest_sdk_version", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetOrderManagementApps requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestLoggingTokenField () {
      return this.requestLoggingTokenField(true);
    }
    public APIRequestGetOrderManagementApps requestLoggingTokenField (boolean value) {
      this.requestField("logging_token", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestLogoUrlField () {
      return this.requestLogoUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestLogoUrlField (boolean value) {
      this.requestField("logo_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestMigrationsField () {
      return this.requestMigrationsField(true);
    }
    public APIRequestGetOrderManagementApps requestMigrationsField (boolean value) {
      this.requestField("migrations", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestMobileProfileSectionUrlField () {
      return this.requestMobileProfileSectionUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestMobileProfileSectionUrlField (boolean value) {
      this.requestField("mobile_profile_section_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestMobileWebUrlField () {
      return this.requestMobileWebUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestMobileWebUrlField (boolean value) {
      this.requestField("mobile_web_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestMonthlyActiveUsersField () {
      return this.requestMonthlyActiveUsersField(true);
    }
    public APIRequestGetOrderManagementApps requestMonthlyActiveUsersField (boolean value) {
      this.requestField("monthly_active_users", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestMonthlyActiveUsersRankField () {
      return this.requestMonthlyActiveUsersRankField(true);
    }
    public APIRequestGetOrderManagementApps requestMonthlyActiveUsersRankField (boolean value) {
      this.requestField("monthly_active_users_rank", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOrderManagementApps requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestNamespaceField () {
      return this.requestNamespaceField(true);
    }
    public APIRequestGetOrderManagementApps requestNamespaceField (boolean value) {
      this.requestField("namespace", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestObjectStoreUrlsField () {
      return this.requestObjectStoreUrlsField(true);
    }
    public APIRequestGetOrderManagementApps requestObjectStoreUrlsField (boolean value) {
      this.requestField("object_store_urls", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOrderManagementApps requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestPageTabDefaultNameField () {
      return this.requestPageTabDefaultNameField(true);
    }
    public APIRequestGetOrderManagementApps requestPageTabDefaultNameField (boolean value) {
      this.requestField("page_tab_default_name", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestPageTabUrlField () {
      return this.requestPageTabUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestPageTabUrlField (boolean value) {
      this.requestField("page_tab_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestPhotoUrlField () {
      return this.requestPhotoUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestPhotoUrlField (boolean value) {
      this.requestField("photo_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestPrivacyPolicyUrlField () {
      return this.requestPrivacyPolicyUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestPrivacyPolicyUrlField (boolean value) {
      this.requestField("privacy_policy_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestProfileSectionUrlField () {
      return this.requestProfileSectionUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestProfileSectionUrlField (boolean value) {
      this.requestField("profile_section_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestPropertyIdField () {
      return this.requestPropertyIdField(true);
    }
    public APIRequestGetOrderManagementApps requestPropertyIdField (boolean value) {
      this.requestField("property_id", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestProtectedModeRulesField () {
      return this.requestProtectedModeRulesField(true);
    }
    public APIRequestGetOrderManagementApps requestProtectedModeRulesField (boolean value) {
      this.requestField("protected_mode_rules", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestRealTimeModeDevicesField () {
      return this.requestRealTimeModeDevicesField(true);
    }
    public APIRequestGetOrderManagementApps requestRealTimeModeDevicesField (boolean value) {
      this.requestField("real_time_mode_devices", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestRestrictionsField () {
      return this.requestRestrictionsField(true);
    }
    public APIRequestGetOrderManagementApps requestRestrictionsField (boolean value) {
      this.requestField("restrictions", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestRestrictiveDataFilterParamsField () {
      return this.requestRestrictiveDataFilterParamsField(true);
    }
    public APIRequestGetOrderManagementApps requestRestrictiveDataFilterParamsField (boolean value) {
      this.requestField("restrictive_data_filter_params", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestRestrictiveDataFilterRulesField () {
      return this.requestRestrictiveDataFilterRulesField(true);
    }
    public APIRequestGetOrderManagementApps requestRestrictiveDataFilterRulesField (boolean value) {
      this.requestField("restrictive_data_filter_rules", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSdkUpdateMessageField () {
      return this.requestSdkUpdateMessageField(true);
    }
    public APIRequestGetOrderManagementApps requestSdkUpdateMessageField (boolean value) {
      this.requestField("sdk_update_message", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSeamlessLoginField () {
      return this.requestSeamlessLoginField(true);
    }
    public APIRequestGetOrderManagementApps requestSeamlessLoginField (boolean value) {
      this.requestField("seamless_login", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSecureCanvasUrlField () {
      return this.requestSecureCanvasUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestSecureCanvasUrlField (boolean value) {
      this.requestField("secure_canvas_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSecurePageTabUrlField () {
      return this.requestSecurePageTabUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestSecurePageTabUrlField (boolean value) {
      this.requestField("secure_page_tab_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestServerIpWhitelistField () {
      return this.requestServerIpWhitelistField(true);
    }
    public APIRequestGetOrderManagementApps requestServerIpWhitelistField (boolean value) {
      this.requestField("server_ip_whitelist", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSmartLoginBookmarkIconUrlField () {
      return this.requestSmartLoginBookmarkIconUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestSmartLoginBookmarkIconUrlField (boolean value) {
      this.requestField("smart_login_bookmark_icon_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSmartLoginMenuIconUrlField () {
      return this.requestSmartLoginMenuIconUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestSmartLoginMenuIconUrlField (boolean value) {
      this.requestField("smart_login_menu_icon_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSocialDiscoveryField () {
      return this.requestSocialDiscoveryField(true);
    }
    public APIRequestGetOrderManagementApps requestSocialDiscoveryField (boolean value) {
      this.requestField("social_discovery", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSubcategoryField () {
      return this.requestSubcategoryField(true);
    }
    public APIRequestGetOrderManagementApps requestSubcategoryField (boolean value) {
      this.requestField("subcategory", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSuggestedEventsSettingField () {
      return this.requestSuggestedEventsSettingField(true);
    }
    public APIRequestGetOrderManagementApps requestSuggestedEventsSettingField (boolean value) {
      this.requestField("suggested_events_setting", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSupportedPlatformsField () {
      return this.requestSupportedPlatformsField(true);
    }
    public APIRequestGetOrderManagementApps requestSupportedPlatformsField (boolean value) {
      this.requestField("supported_platforms", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSupportsApprequestsFastAppSwitchField () {
      return this.requestSupportsApprequestsFastAppSwitchField(true);
    }
    public APIRequestGetOrderManagementApps requestSupportsApprequestsFastAppSwitchField (boolean value) {
      this.requestField("supports_apprequests_fast_app_switch", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSupportsAttributionField () {
      return this.requestSupportsAttributionField(true);
    }
    public APIRequestGetOrderManagementApps requestSupportsAttributionField (boolean value) {
      this.requestField("supports_attribution", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSupportsImplicitSdkLoggingField () {
      return this.requestSupportsImplicitSdkLoggingField(true);
    }
    public APIRequestGetOrderManagementApps requestSupportsImplicitSdkLoggingField (boolean value) {
      this.requestField("supports_implicit_sdk_logging", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestSuppressNativeIosGdpField () {
      return this.requestSuppressNativeIosGdpField(true);
    }
    public APIRequestGetOrderManagementApps requestSuppressNativeIosGdpField (boolean value) {
      this.requestField("suppress_native_ios_gdp", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestTermsOfServiceUrlField () {
      return this.requestTermsOfServiceUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestTermsOfServiceUrlField (boolean value) {
      this.requestField("terms_of_service_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestUrlSchemeSuffixField () {
      return this.requestUrlSchemeSuffixField(true);
    }
    public APIRequestGetOrderManagementApps requestUrlSchemeSuffixField (boolean value) {
      this.requestField("url_scheme_suffix", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestUserSupportEmailField () {
      return this.requestUserSupportEmailField(true);
    }
    public APIRequestGetOrderManagementApps requestUserSupportEmailField (boolean value) {
      this.requestField("user_support_email", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestUserSupportUrlField () {
      return this.requestUserSupportUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestUserSupportUrlField (boolean value) {
      this.requestField("user_support_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestWebsiteUrlField () {
      return this.requestWebsiteUrlField(true);
    }
    public APIRequestGetOrderManagementApps requestWebsiteUrlField (boolean value) {
      this.requestField("website_url", value);
      return this;
    }
    public APIRequestGetOrderManagementApps requestWeeklyActiveUsersField () {
      return this.requestWeeklyActiveUsersField(true);
    }
    public APIRequestGetOrderManagementApps requestWeeklyActiveUsersField (boolean value) {
      this.requestField("weekly_active_users", value);
      return this;
    }
  }

  public static class APIRequestCreateOrderManagementApp extends APIRequest<CommerceMerchantSettings> {

    CommerceMerchantSettings lastResponse = null;
    @Override
    public CommerceMerchantSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CommerceMerchantSettings parseResponse(String response, String header) throws APIException {
      return CommerceMerchantSettings.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceMerchantSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceMerchantSettings execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceMerchantSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceMerchantSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceMerchantSettings>() {
           public CommerceMerchantSettings apply(ResponseWrapper result) {
             try {
               return APIRequestCreateOrderManagementApp.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateOrderManagementApp(String nodeId, APIContext context) {
      super(context, nodeId, "/order_management_apps", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOrderManagementApp setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOrderManagementApp setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOrderManagementApp requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOrderManagementApp requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOrderManagementApp requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOrderManagementApp requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOrderManagementApp requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOrderManagementApp requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetProductCatalogs extends APIRequest<ProductCatalog> {

    APINodeList<ProductCatalog> lastResponse = null;
    @Override
    public APINodeList<ProductCatalog> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_to_collaborative_ads_share_settings",
      "agency_collaborative_ads_share_settings",
      "business",
      "catalog_store",
      "commerce_merchant_settings",
      "creator_user",
      "da_display_settings",
      "default_image_url",
      "fallback_image_url",
      "feed_count",
      "id",
      "is_catalog_segment",
      "is_local_catalog",
      "name",
      "owner_business",
      "product_count",
      "store_catalog_settings",
      "user_access_expire_time",
      "vertical",
    };

    @Override
    public APINodeList<ProductCatalog> parseResponse(String response, String header) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductCatalog> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalog> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductCatalog>>() {
           public APINodeList<ProductCatalog> apply(ResponseWrapper result) {
             try {
               return APIRequestGetProductCatalogs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/product_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductCatalogs requestAdAccountToCollaborativeAdsShareSettingsField () {
      return this.requestAdAccountToCollaborativeAdsShareSettingsField(true);
    }
    public APIRequestGetProductCatalogs requestAdAccountToCollaborativeAdsShareSettingsField (boolean value) {
      this.requestField("ad_account_to_collaborative_ads_share_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestAgencyCollaborativeAdsShareSettingsField () {
      return this.requestAgencyCollaborativeAdsShareSettingsField(true);
    }
    public APIRequestGetProductCatalogs requestAgencyCollaborativeAdsShareSettingsField (boolean value) {
      this.requestField("agency_collaborative_ads_share_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestCatalogStoreField () {
      return this.requestCatalogStoreField(true);
    }
    public APIRequestGetProductCatalogs requestCatalogStoreField (boolean value) {
      this.requestField("catalog_store", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestCommerceMerchantSettingsField () {
      return this.requestCommerceMerchantSettingsField(true);
    }
    public APIRequestGetProductCatalogs requestCommerceMerchantSettingsField (boolean value) {
      this.requestField("commerce_merchant_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestCreatorUserField () {
      return this.requestCreatorUserField(true);
    }
    public APIRequestGetProductCatalogs requestCreatorUserField (boolean value) {
      this.requestField("creator_user", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestDaDisplaySettingsField () {
      return this.requestDaDisplaySettingsField(true);
    }
    public APIRequestGetProductCatalogs requestDaDisplaySettingsField (boolean value) {
      this.requestField("da_display_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestDefaultImageUrlField () {
      return this.requestDefaultImageUrlField(true);
    }
    public APIRequestGetProductCatalogs requestDefaultImageUrlField (boolean value) {
      this.requestField("default_image_url", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestFallbackImageUrlField () {
      return this.requestFallbackImageUrlField(true);
    }
    public APIRequestGetProductCatalogs requestFallbackImageUrlField (boolean value) {
      this.requestField("fallback_image_url", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGetProductCatalogs requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestIsCatalogSegmentField () {
      return this.requestIsCatalogSegmentField(true);
    }
    public APIRequestGetProductCatalogs requestIsCatalogSegmentField (boolean value) {
      this.requestField("is_catalog_segment", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestIsLocalCatalogField () {
      return this.requestIsLocalCatalogField(true);
    }
    public APIRequestGetProductCatalogs requestIsLocalCatalogField (boolean value) {
      this.requestField("is_local_catalog", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetProductCatalogs requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestStoreCatalogSettingsField () {
      return this.requestStoreCatalogSettingsField(true);
    }
    public APIRequestGetProductCatalogs requestStoreCatalogSettingsField (boolean value) {
      this.requestField("store_catalog_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetProductCatalogs requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetProductCatalogs requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestGetReturns extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_time_created",
      "merchant_return_id",
      "start_time_created",
      "statuses",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetReturns.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetReturns(String nodeId, APIContext context) {
      super(context, nodeId, "/returns", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReturns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReturns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReturns setEndTimeCreated (String endTimeCreated) {
      this.setParam("end_time_created", endTimeCreated);
      return this;
    }

    public APIRequestGetReturns setMerchantReturnId (String merchantReturnId) {
      this.setParam("merchant_return_id", merchantReturnId);
      return this;
    }

    public APIRequestGetReturns setStartTimeCreated (String startTimeCreated) {
      this.setParam("start_time_created", startTimeCreated);
      return this;
    }

    public APIRequestGetReturns setStatuses (List<EnumStatuses> statuses) {
      this.setParam("statuses", statuses);
      return this;
    }
    public APIRequestGetReturns setStatuses (String statuses) {
      this.setParam("statuses", statuses);
      return this;
    }

    public APIRequestGetReturns requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReturns requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReturns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReturns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReturns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReturns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetSetupStatus extends APIRequest<CommerceMerchantSettingsSetupStatus> {

    APINodeList<CommerceMerchantSettingsSetupStatus> lastResponse = null;
    @Override
    public APINodeList<CommerceMerchantSettingsSetupStatus> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "deals_setup",
      "marketplace_approval_status",
      "marketplace_approval_status_details",
      "payment_setup",
      "review_status",
      "shop_setup",
    };

    @Override
    public APINodeList<CommerceMerchantSettingsSetupStatus> parseResponse(String response, String header) throws APIException {
      return CommerceMerchantSettingsSetupStatus.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CommerceMerchantSettingsSetupStatus> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CommerceMerchantSettingsSetupStatus> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CommerceMerchantSettingsSetupStatus>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CommerceMerchantSettingsSetupStatus>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CommerceMerchantSettingsSetupStatus>>() {
           public APINodeList<CommerceMerchantSettingsSetupStatus> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSetupStatus.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSetupStatus(String nodeId, APIContext context) {
      super(context, nodeId, "/setup_status", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSetupStatus setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSetupStatus setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSetupStatus requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSetupStatus requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSetupStatus requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSetupStatus requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSetupStatus requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSetupStatus requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSetupStatus requestDealsSetupField () {
      return this.requestDealsSetupField(true);
    }
    public APIRequestGetSetupStatus requestDealsSetupField (boolean value) {
      this.requestField("deals_setup", value);
      return this;
    }
    public APIRequestGetSetupStatus requestMarketplaceApprovalStatusField () {
      return this.requestMarketplaceApprovalStatusField(true);
    }
    public APIRequestGetSetupStatus requestMarketplaceApprovalStatusField (boolean value) {
      this.requestField("marketplace_approval_status", value);
      return this;
    }
    public APIRequestGetSetupStatus requestMarketplaceApprovalStatusDetailsField () {
      return this.requestMarketplaceApprovalStatusDetailsField(true);
    }
    public APIRequestGetSetupStatus requestMarketplaceApprovalStatusDetailsField (boolean value) {
      this.requestField("marketplace_approval_status_details", value);
      return this;
    }
    public APIRequestGetSetupStatus requestPaymentSetupField () {
      return this.requestPaymentSetupField(true);
    }
    public APIRequestGetSetupStatus requestPaymentSetupField (boolean value) {
      this.requestField("payment_setup", value);
      return this;
    }
    public APIRequestGetSetupStatus requestReviewStatusField () {
      return this.requestReviewStatusField(true);
    }
    public APIRequestGetSetupStatus requestReviewStatusField (boolean value) {
      this.requestField("review_status", value);
      return this;
    }
    public APIRequestGetSetupStatus requestShopSetupField () {
      return this.requestShopSetupField(true);
    }
    public APIRequestGetSetupStatus requestShopSetupField (boolean value) {
      this.requestField("shop_setup", value);
      return this;
    }
  }

  public static class APIRequestGetShippingProfiles extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "reference_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetShippingProfiles.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetShippingProfiles(String nodeId, APIContext context) {
      super(context, nodeId, "/shipping_profiles", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetShippingProfiles setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetShippingProfiles setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetShippingProfiles setReferenceId (String referenceId) {
      this.setParam("reference_id", referenceId);
      return this;
    }

    public APIRequestGetShippingProfiles requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetShippingProfiles requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShippingProfiles requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetShippingProfiles requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShippingProfiles requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetShippingProfiles requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateShippingProfile extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "handling_time",
      "is_default",
      "is_default_shipping_profile",
      "name",
      "reference_id",
      "shipping_destinations",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateShippingProfile.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateShippingProfile(String nodeId, APIContext context) {
      super(context, nodeId, "/shipping_profiles", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateShippingProfile setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateShippingProfile setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateShippingProfile setHandlingTime (Map<String, String> handlingTime) {
      this.setParam("handling_time", handlingTime);
      return this;
    }
    public APIRequestCreateShippingProfile setHandlingTime (String handlingTime) {
      this.setParam("handling_time", handlingTime);
      return this;
    }

    public APIRequestCreateShippingProfile setIsDefault (Boolean isDefault) {
      this.setParam("is_default", isDefault);
      return this;
    }
    public APIRequestCreateShippingProfile setIsDefault (String isDefault) {
      this.setParam("is_default", isDefault);
      return this;
    }

    public APIRequestCreateShippingProfile setIsDefaultShippingProfile (Boolean isDefaultShippingProfile) {
      this.setParam("is_default_shipping_profile", isDefaultShippingProfile);
      return this;
    }
    public APIRequestCreateShippingProfile setIsDefaultShippingProfile (String isDefaultShippingProfile) {
      this.setParam("is_default_shipping_profile", isDefaultShippingProfile);
      return this;
    }

    public APIRequestCreateShippingProfile setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateShippingProfile setReferenceId (String referenceId) {
      this.setParam("reference_id", referenceId);
      return this;
    }

    public APIRequestCreateShippingProfile setShippingDestinations (List<Map<String, String>> shippingDestinations) {
      this.setParam("shipping_destinations", shippingDestinations);
      return this;
    }
    public APIRequestCreateShippingProfile setShippingDestinations (String shippingDestinations) {
      this.setParam("shipping_destinations", shippingDestinations);
      return this;
    }

    public APIRequestCreateShippingProfile requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateShippingProfile requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateShippingProfile requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateShippingProfile requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateShippingProfile requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateShippingProfile requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetShops extends APIRequest<Shop> {

    APINodeList<Shop> lastResponse = null;
    @Override
    public APINodeList<Shop> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "commerce_merchant_settings",
      "fb_sales_channel",
      "id",
      "ig_sales_channel",
      "is_onsite_enabled",
      "shop_status",
      "workspace",
    };

    @Override
    public APINodeList<Shop> parseResponse(String response, String header) throws APIException {
      return Shop.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Shop> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Shop> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Shop>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Shop>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Shop>>() {
           public APINodeList<Shop> apply(ResponseWrapper result) {
             try {
               return APIRequestGetShops.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetShops(String nodeId, APIContext context) {
      super(context, nodeId, "/shops", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetShops setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetShops setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetShops requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetShops requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShops requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetShops requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShops requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetShops requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetShops requestCommerceMerchantSettingsField () {
      return this.requestCommerceMerchantSettingsField(true);
    }
    public APIRequestGetShops requestCommerceMerchantSettingsField (boolean value) {
      this.requestField("commerce_merchant_settings", value);
      return this;
    }
    public APIRequestGetShops requestFbSalesChannelField () {
      return this.requestFbSalesChannelField(true);
    }
    public APIRequestGetShops requestFbSalesChannelField (boolean value) {
      this.requestField("fb_sales_channel", value);
      return this;
    }
    public APIRequestGetShops requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetShops requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetShops requestIgSalesChannelField () {
      return this.requestIgSalesChannelField(true);
    }
    public APIRequestGetShops requestIgSalesChannelField (boolean value) {
      this.requestField("ig_sales_channel", value);
      return this;
    }
    public APIRequestGetShops requestIsOnsiteEnabledField () {
      return this.requestIsOnsiteEnabledField(true);
    }
    public APIRequestGetShops requestIsOnsiteEnabledField (boolean value) {
      this.requestField("is_onsite_enabled", value);
      return this;
    }
    public APIRequestGetShops requestShopStatusField () {
      return this.requestShopStatusField(true);
    }
    public APIRequestGetShops requestShopStatusField (boolean value) {
      this.requestField("shop_status", value);
      return this;
    }
    public APIRequestGetShops requestWorkspaceField () {
      return this.requestWorkspaceField(true);
    }
    public APIRequestGetShops requestWorkspaceField (boolean value) {
      this.requestField("workspace", value);
      return this;
    }
  }

  public static class APIRequestGetTaxSettings extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTaxSettings.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetTaxSettings(String nodeId, APIContext context) {
      super(context, nodeId, "/tax_settings", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTaxSettings setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTaxSettings setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTaxSettings requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTaxSettings requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTaxSettings requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTaxSettings requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTaxSettings requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTaxSettings requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<CommerceMerchantSettings> {

    CommerceMerchantSettings lastResponse = null;
    @Override
    public CommerceMerchantSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "checkout_config",
      "checkout_message",
      "contact_email",
      "cta",
      "display_name",
      "facebook_channel",
      "id",
      "instagram_channel",
      "korea_ftc_listing",
      "merchant_page",
      "merchant_status",
      "offsite_iab_checkout_enabled_countries",
      "onsite_commerce_merchant",
      "payment_provider",
      "privacy_policy_localized",
      "return_policy_localized",
      "review_rejection_messages",
      "review_rejection_reasons",
      "shops_ads_setup",
      "terms",
    };

    @Override
    public CommerceMerchantSettings parseResponse(String response, String header) throws APIException {
      return CommerceMerchantSettings.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceMerchantSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceMerchantSettings execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceMerchantSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceMerchantSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceMerchantSettings>() {
           public CommerceMerchantSettings apply(ResponseWrapper result) {
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

    public APIRequestGet requestCheckoutConfigField () {
      return this.requestCheckoutConfigField(true);
    }
    public APIRequestGet requestCheckoutConfigField (boolean value) {
      this.requestField("checkout_config", value);
      return this;
    }
    public APIRequestGet requestCheckoutMessageField () {
      return this.requestCheckoutMessageField(true);
    }
    public APIRequestGet requestCheckoutMessageField (boolean value) {
      this.requestField("checkout_message", value);
      return this;
    }
    public APIRequestGet requestContactEmailField () {
      return this.requestContactEmailField(true);
    }
    public APIRequestGet requestContactEmailField (boolean value) {
      this.requestField("contact_email", value);
      return this;
    }
    public APIRequestGet requestCtaField () {
      return this.requestCtaField(true);
    }
    public APIRequestGet requestCtaField (boolean value) {
      this.requestField("cta", value);
      return this;
    }
    public APIRequestGet requestDisplayNameField () {
      return this.requestDisplayNameField(true);
    }
    public APIRequestGet requestDisplayNameField (boolean value) {
      this.requestField("display_name", value);
      return this;
    }
    public APIRequestGet requestFacebookChannelField () {
      return this.requestFacebookChannelField(true);
    }
    public APIRequestGet requestFacebookChannelField (boolean value) {
      this.requestField("facebook_channel", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInstagramChannelField () {
      return this.requestInstagramChannelField(true);
    }
    public APIRequestGet requestInstagramChannelField (boolean value) {
      this.requestField("instagram_channel", value);
      return this;
    }
    public APIRequestGet requestKoreaFtcListingField () {
      return this.requestKoreaFtcListingField(true);
    }
    public APIRequestGet requestKoreaFtcListingField (boolean value) {
      this.requestField("korea_ftc_listing", value);
      return this;
    }
    public APIRequestGet requestMerchantPageField () {
      return this.requestMerchantPageField(true);
    }
    public APIRequestGet requestMerchantPageField (boolean value) {
      this.requestField("merchant_page", value);
      return this;
    }
    public APIRequestGet requestMerchantStatusField () {
      return this.requestMerchantStatusField(true);
    }
    public APIRequestGet requestMerchantStatusField (boolean value) {
      this.requestField("merchant_status", value);
      return this;
    }
    public APIRequestGet requestOffsiteIabCheckoutEnabledCountriesField () {
      return this.requestOffsiteIabCheckoutEnabledCountriesField(true);
    }
    public APIRequestGet requestOffsiteIabCheckoutEnabledCountriesField (boolean value) {
      this.requestField("offsite_iab_checkout_enabled_countries", value);
      return this;
    }
    public APIRequestGet requestOnsiteCommerceMerchantField () {
      return this.requestOnsiteCommerceMerchantField(true);
    }
    public APIRequestGet requestOnsiteCommerceMerchantField (boolean value) {
      this.requestField("onsite_commerce_merchant", value);
      return this;
    }
    public APIRequestGet requestPaymentProviderField () {
      return this.requestPaymentProviderField(true);
    }
    public APIRequestGet requestPaymentProviderField (boolean value) {
      this.requestField("payment_provider", value);
      return this;
    }
    public APIRequestGet requestPrivacyPolicyLocalizedField () {
      return this.requestPrivacyPolicyLocalizedField(true);
    }
    public APIRequestGet requestPrivacyPolicyLocalizedField (boolean value) {
      this.requestField("privacy_policy_localized", value);
      return this;
    }
    public APIRequestGet requestReturnPolicyLocalizedField () {
      return this.requestReturnPolicyLocalizedField(true);
    }
    public APIRequestGet requestReturnPolicyLocalizedField (boolean value) {
      this.requestField("return_policy_localized", value);
      return this;
    }
    public APIRequestGet requestReviewRejectionMessagesField () {
      return this.requestReviewRejectionMessagesField(true);
    }
    public APIRequestGet requestReviewRejectionMessagesField (boolean value) {
      this.requestField("review_rejection_messages", value);
      return this;
    }
    public APIRequestGet requestReviewRejectionReasonsField () {
      return this.requestReviewRejectionReasonsField(true);
    }
    public APIRequestGet requestReviewRejectionReasonsField (boolean value) {
      this.requestField("review_rejection_reasons", value);
      return this;
    }
    public APIRequestGet requestShopsAdsSetupField () {
      return this.requestShopsAdsSetupField(true);
    }
    public APIRequestGet requestShopsAdsSetupField (boolean value) {
      this.requestField("shops_ads_setup", value);
      return this;
    }
    public APIRequestGet requestTermsField () {
      return this.requestTermsField(true);
    }
    public APIRequestGet requestTermsField (boolean value) {
      this.requestField("terms", value);
      return this;
    }
  }

  public static enum EnumStatuses {
      @SerializedName("APPROVED")
      VALUE_APPROVED("APPROVED"),
      @SerializedName("DISAPPROVED")
      VALUE_DISAPPROVED("DISAPPROVED"),
      @SerializedName("MERCHANT_MARKED_COMPLETED")
      VALUE_MERCHANT_MARKED_COMPLETED("MERCHANT_MARKED_COMPLETED"),
      @SerializedName("REFUNDED")
      VALUE_REFUNDED("REFUNDED"),
      @SerializedName("REQUESTED")
      VALUE_REQUESTED("REQUESTED"),
      ;

      private String value;

      private EnumStatuses(String value) {
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

  public CommerceMerchantSettings copyFrom(CommerceMerchantSettings instance) {
    this.mCheckoutConfig = instance.mCheckoutConfig;
    this.mCheckoutMessage = instance.mCheckoutMessage;
    this.mContactEmail = instance.mContactEmail;
    this.mCta = instance.mCta;
    this.mDisplayName = instance.mDisplayName;
    this.mFacebookChannel = instance.mFacebookChannel;
    this.mId = instance.mId;
    this.mInstagramChannel = instance.mInstagramChannel;
    this.mKoreaFtcListing = instance.mKoreaFtcListing;
    this.mMerchantPage = instance.mMerchantPage;
    this.mMerchantStatus = instance.mMerchantStatus;
    this.mOffsiteIabCheckoutEnabledCountries = instance.mOffsiteIabCheckoutEnabledCountries;
    this.mOnsiteCommerceMerchant = instance.mOnsiteCommerceMerchant;
    this.mPaymentProvider = instance.mPaymentProvider;
    this.mPrivacyPolicyLocalized = instance.mPrivacyPolicyLocalized;
    this.mReturnPolicyLocalized = instance.mReturnPolicyLocalized;
    this.mReviewRejectionMessages = instance.mReviewRejectionMessages;
    this.mReviewRejectionReasons = instance.mReviewRejectionReasons;
    this.mShopsAdsSetup = instance.mShopsAdsSetup;
    this.mTerms = instance.mTerms;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CommerceMerchantSettings> getParser() {
    return new APIRequest.ResponseParser<CommerceMerchantSettings>() {
      public APINodeList<CommerceMerchantSettings> parseResponse(String response, APIContext context, APIRequest<CommerceMerchantSettings> request, String header) throws MalformedResponseException {
        return CommerceMerchantSettings.parseResponse(response, context, request, header);
      }
    };
  }
}
