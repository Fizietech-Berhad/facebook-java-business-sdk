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
public class ProductCatalogLocalizedItemsBatchPost extends APINode {
  @SerializedName("handles")
  private List<String> mHandles = null;
  @SerializedName("validation_status")
  private List<Object> mValidationStatus = null;
  protected static Gson gson = null;

  public ProductCatalogLocalizedItemsBatchPost() {
  }

  public String getId() {
    return null;
  }
  public static ProductCatalogLocalizedItemsBatchPost loadJSON(String json, APIContext context, String header) {
    ProductCatalogLocalizedItemsBatchPost productCatalogLocalizedItemsBatchPost = getGson().fromJson(json, ProductCatalogLocalizedItemsBatchPost.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productCatalogLocalizedItemsBatchPost.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productCatalogLocalizedItemsBatchPost.context = context;
    productCatalogLocalizedItemsBatchPost.rawValue = json;
    productCatalogLocalizedItemsBatchPost.header = header;
    return productCatalogLocalizedItemsBatchPost;
  }

  public static APINodeList<ProductCatalogLocalizedItemsBatchPost> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductCatalogLocalizedItemsBatchPost> productCatalogLocalizedItemsBatchPosts = new APINodeList<ProductCatalogLocalizedItemsBatchPost>(request, json, header);
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
          productCatalogLocalizedItemsBatchPosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productCatalogLocalizedItemsBatchPosts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productCatalogLocalizedItemsBatchPosts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productCatalogLocalizedItemsBatchPosts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productCatalogLocalizedItemsBatchPosts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productCatalogLocalizedItemsBatchPosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productCatalogLocalizedItemsBatchPosts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productCatalogLocalizedItemsBatchPosts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productCatalogLocalizedItemsBatchPosts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productCatalogLocalizedItemsBatchPosts.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productCatalogLocalizedItemsBatchPosts;
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
              productCatalogLocalizedItemsBatchPosts.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productCatalogLocalizedItemsBatchPosts;
          }

          // Sixth, check if it's pure JsonObject
          productCatalogLocalizedItemsBatchPosts.clear();
          productCatalogLocalizedItemsBatchPosts.add(loadJSON(json, context, header));
          return productCatalogLocalizedItemsBatchPosts;
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


  public List<String> getFieldHandles() {
    return mHandles;
  }

  public ProductCatalogLocalizedItemsBatchPost setFieldHandles(List<String> value) {
    this.mHandles = value;
    return this;
  }

  public List<Object> getFieldValidationStatus() {
    return mValidationStatus;
  }

  public ProductCatalogLocalizedItemsBatchPost setFieldValidationStatus(List<Object> value) {
    this.mValidationStatus = value;
    return this;
  }



  public static enum EnumItemSubType {
      @SerializedName("APPLIANCES")
      VALUE_APPLIANCES("APPLIANCES"),
      @SerializedName("BABY_FEEDING")
      VALUE_BABY_FEEDING("BABY_FEEDING"),
      @SerializedName("BABY_TRANSPORT")
      VALUE_BABY_TRANSPORT("BABY_TRANSPORT"),
      @SerializedName("BEAUTY")
      VALUE_BEAUTY("BEAUTY"),
      @SerializedName("BEDDING")
      VALUE_BEDDING("BEDDING"),
      @SerializedName("CAMERAS")
      VALUE_CAMERAS("CAMERAS"),
      @SerializedName("CAMERAS_AND_PHOTOS")
      VALUE_CAMERAS_AND_PHOTOS("CAMERAS_AND_PHOTOS"),
      @SerializedName("CELL_PHONES_AND_SMART_WATCHES")
      VALUE_CELL_PHONES_AND_SMART_WATCHES("CELL_PHONES_AND_SMART_WATCHES"),
      @SerializedName("CLEANING_SUPPLIES")
      VALUE_CLEANING_SUPPLIES("CLEANING_SUPPLIES"),
      @SerializedName("CLOTHING")
      VALUE_CLOTHING("CLOTHING"),
      @SerializedName("CLOTHING_ACCESSORIES")
      VALUE_CLOTHING_ACCESSORIES("CLOTHING_ACCESSORIES"),
      @SerializedName("CLO_OFFER")
      VALUE_CLO_OFFER("CLO_OFFER"),
      @SerializedName("COMPUTERS_AND_TABLETS")
      VALUE_COMPUTERS_AND_TABLETS("COMPUTERS_AND_TABLETS"),
      @SerializedName("COMPUTERS_LAPTOPS_AND_TABLETS")
      VALUE_COMPUTERS_LAPTOPS_AND_TABLETS("COMPUTERS_LAPTOPS_AND_TABLETS"),
      @SerializedName("COMPUTER_COMPONENTS")
      VALUE_COMPUTER_COMPONENTS("COMPUTER_COMPONENTS"),
      @SerializedName("DIAPERING_AND_POTTY_TRAINING")
      VALUE_DIAPERING_AND_POTTY_TRAINING("DIAPERING_AND_POTTY_TRAINING"),
      @SerializedName("ELECTRONICS_ACCESSORIES")
      VALUE_ELECTRONICS_ACCESSORIES("ELECTRONICS_ACCESSORIES"),
      @SerializedName("ELECTRONIC_ACCESSORIES_AND_CABLES")
      VALUE_ELECTRONIC_ACCESSORIES_AND_CABLES("ELECTRONIC_ACCESSORIES_AND_CABLES"),
      @SerializedName("EMPTY")
      VALUE_EMPTY("EMPTY"),
      @SerializedName("FURNITURE")
      VALUE_FURNITURE("FURNITURE"),
      @SerializedName("HEALTH")
      VALUE_HEALTH("HEALTH"),
      @SerializedName("HOME")
      VALUE_HOME("HOME"),
      @SerializedName("HOME_GOODS")
      VALUE_HOME_GOODS("HOME_GOODS"),
      @SerializedName("HOUSEHOLD_AND_CLEANING_SUPPLIES")
      VALUE_HOUSEHOLD_AND_CLEANING_SUPPLIES("HOUSEHOLD_AND_CLEANING_SUPPLIES"),
      @SerializedName("JEWELRY")
      VALUE_JEWELRY("JEWELRY"),
      @SerializedName("LARGE_APPLIANCES")
      VALUE_LARGE_APPLIANCES("LARGE_APPLIANCES"),
      @SerializedName("LOCAL_SERVICE_BUSINESS_ITEM")
      VALUE_LOCAL_SERVICE_BUSINESS_ITEM("LOCAL_SERVICE_BUSINESS_ITEM"),
      @SerializedName("LOCAL_SERVICE_BUSINESS_RESTAURANT")
      VALUE_LOCAL_SERVICE_BUSINESS_RESTAURANT("LOCAL_SERVICE_BUSINESS_RESTAURANT"),
      @SerializedName("NURSERY")
      VALUE_NURSERY("NURSERY"),
      @SerializedName("PRINTERS_AND_SCANNERS")
      VALUE_PRINTERS_AND_SCANNERS("PRINTERS_AND_SCANNERS"),
      @SerializedName("PRINTERS_SCANNERS_AND_FAX_MACHINES")
      VALUE_PRINTERS_SCANNERS_AND_FAX_MACHINES("PRINTERS_SCANNERS_AND_FAX_MACHINES"),
      @SerializedName("PRODUCT_DISCOUNT")
      VALUE_PRODUCT_DISCOUNT("PRODUCT_DISCOUNT"),
      @SerializedName("PROJECTORS")
      VALUE_PROJECTORS("PROJECTORS"),
      @SerializedName("SHOES")
      VALUE_SHOES("SHOES"),
      @SerializedName("SHOES_AND_FOOTWEAR")
      VALUE_SHOES_AND_FOOTWEAR("SHOES_AND_FOOTWEAR"),
      @SerializedName("SOFTWARE")
      VALUE_SOFTWARE("SOFTWARE"),
      @SerializedName("TELEVISIONS_AND_MONITORS")
      VALUE_TELEVISIONS_AND_MONITORS("TELEVISIONS_AND_MONITORS"),
      @SerializedName("TEST_CHILD_SUB_VERTICAL")
      VALUE_TEST_CHILD_SUB_VERTICAL("TEST_CHILD_SUB_VERTICAL"),
      @SerializedName("TEST_GRAND_CHILD_SUB_VERTICAL")
      VALUE_TEST_GRAND_CHILD_SUB_VERTICAL("TEST_GRAND_CHILD_SUB_VERTICAL"),
      @SerializedName("TEST_SUB_VERTICAL")
      VALUE_TEST_SUB_VERTICAL("TEST_SUB_VERTICAL"),
      @SerializedName("TEST_SUB_VERTICAL_ALIAS")
      VALUE_TEST_SUB_VERTICAL_ALIAS("TEST_SUB_VERTICAL_ALIAS"),
      @SerializedName("TEST_SUB_VERTICAL_DATA_OBJECT")
      VALUE_TEST_SUB_VERTICAL_DATA_OBJECT("TEST_SUB_VERTICAL_DATA_OBJECT"),
      @SerializedName("THIRD_PARTY_ELECTRONICS")
      VALUE_THIRD_PARTY_ELECTRONICS("THIRD_PARTY_ELECTRONICS"),
      @SerializedName("THIRD_PARTY_TOYS_AND_GAMES")
      VALUE_THIRD_PARTY_TOYS_AND_GAMES("THIRD_PARTY_TOYS_AND_GAMES"),
      @SerializedName("TOYS")
      VALUE_TOYS("TOYS"),
      @SerializedName("TOYS_AND_GAMES")
      VALUE_TOYS_AND_GAMES("TOYS_AND_GAMES"),
      @SerializedName("TVS_AND_MONITORS")
      VALUE_TVS_AND_MONITORS("TVS_AND_MONITORS"),
      @SerializedName("VEHICLE_MANUFACTURER")
      VALUE_VEHICLE_MANUFACTURER("VEHICLE_MANUFACTURER"),
      @SerializedName("VIDEO_GAMES_AND_CONSOLES")
      VALUE_VIDEO_GAMES_AND_CONSOLES("VIDEO_GAMES_AND_CONSOLES"),
      @SerializedName("VIDEO_GAME_CONSOLES_AND_VIDEO_GAMES")
      VALUE_VIDEO_GAME_CONSOLES_AND_VIDEO_GAMES("VIDEO_GAME_CONSOLES_AND_VIDEO_GAMES"),
      @SerializedName("VIDEO_PROJECTORS")
      VALUE_VIDEO_PROJECTORS("VIDEO_PROJECTORS"),
      @SerializedName("WATCHES")
      VALUE_WATCHES("WATCHES"),
      ;

      private String value;

      private EnumItemSubType(String value) {
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

  public ProductCatalogLocalizedItemsBatchPost copyFrom(ProductCatalogLocalizedItemsBatchPost instance) {
    this.mHandles = instance.mHandles;
    this.mValidationStatus = instance.mValidationStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductCatalogLocalizedItemsBatchPost> getParser() {
    return new APIRequest.ResponseParser<ProductCatalogLocalizedItemsBatchPost>() {
      public APINodeList<ProductCatalogLocalizedItemsBatchPost> parseResponse(String response, APIContext context, APIRequest<ProductCatalogLocalizedItemsBatchPost> request, String header) throws MalformedResponseException {
        return ProductCatalogLocalizedItemsBatchPost.parseResponse(response, context, request, header);
      }
    };
  }
}
