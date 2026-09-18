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
public class ProductCatalogProductsPost extends APINode {
  @SerializedName("additional_image_cdn_urls")
  private List<List<Object>> mAdditionalImageCdnUrls = null;
  @SerializedName("additional_image_urls")
  private List<String> mAdditionalImageUrls = null;
  @SerializedName("additional_variant_attributes")
  private List<Object> mAdditionalVariantAttributes = null;
  @SerializedName("age_group")
  private EnumAgeGroup mAgeGroup = null;
  @SerializedName("applinks")
  private Object mApplinks = null;
  @SerializedName("availability")
  private EnumAvailability mAvailability = null;
  @SerializedName("available_quantity_to_sell_on_facebook")
  private Long mAvailableQuantityToSellOnFacebook = null;
  @SerializedName("base_commission_rate")
  private Long mBaseCommissionRate = null;
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("capabilities_disabled_by_user")
  private List<String> mCapabilitiesDisabledByUser = null;
  @SerializedName("capability_features")
  private List<String> mCapabilityFeatures = null;
  @SerializedName("capability_to_review_status")
  private List<Object> mCapabilityToReviewStatus = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("category_specific_fields")
  private Map<Object, Object> mCategorySpecificFields = null;
  @SerializedName("channels_to_integrity_status")
  private Object mChannelsToIntegrityStatus = null;
  @SerializedName("color")
  private String mColor = null;
  @SerializedName("commerce_insights")
  private Object mCommerceInsights = null;
  @SerializedName("condition")
  private EnumCondition mCondition = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("custom_data")
  private List<Object> mCustomData = null;
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
  private String mCustomNumber0 = null;
  @SerializedName("custom_number_1")
  private String mCustomNumber1 = null;
  @SerializedName("custom_number_2")
  private String mCustomNumber2 = null;
  @SerializedName("custom_number_3")
  private String mCustomNumber3 = null;
  @SerializedName("custom_number_4")
  private String mCustomNumber4 = null;
  @SerializedName("da_display_preview_url")
  private String mDaDisplayPreviewUrl = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("enabled_capability_to_review_status")
  private List<Object> mEnabledCapabilityToReviewStatus = null;
  @SerializedName("errors")
  private List<Object> mErrors = null;
  @SerializedName("expiration_date")
  private String mExpirationDate = null;
  @SerializedName("fb_product_category")
  private String mFbProductCategory = null;
  @SerializedName("gender")
  private EnumGender mGender = null;
  @SerializedName("gtin")
  private String mGtin = null;
  @SerializedName("id")
  private Long mId = null;
  @SerializedName("image_cdn_urls")
  private List<Object> mImageCdnUrls = null;
  @SerializedName("image_fetch_status")
  private String mImageFetchStatus = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("importer_name")
  private String mImporterName = null;
  @SerializedName("invalidation_errors")
  private List<Object> mInvalidationErrors = null;
  @SerializedName("inventory")
  private Long mInventory = null;
  @SerializedName("is_bundle_hero")
  private Boolean mIsBundleHero = null;
  @SerializedName("manufacturer_info")
  private String mManufacturerInfo = null;
  @SerializedName("manufacturer_part_number")
  private String mManufacturerPartNumber = null;
  @SerializedName("material")
  private String mMaterial = null;
  @SerializedName("mobile_link")
  private String mMobileLink = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("ordering_index")
  private Long mOrderingIndex = null;
  @SerializedName("origin_country")
  private String mOriginCountry = null;
  @SerializedName("override_details")
  private Object mOverrideDetails = null;
  @SerializedName("pattern")
  private String mPattern = null;
  @SerializedName("post_conversion_signal_based_enforcement_appeal_eligibility")
  private Boolean mPostConversionSignalBasedEnforcementAppealEligibility = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("product_catalog")
  private Object mProductCatalog = null;
  @SerializedName("product_feed")
  private Object mProductFeed = null;
  @SerializedName("product_group")
  private Object mProductGroup = null;
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
  @SerializedName("product_relationship")
  private String mProductRelationship = null;
  @SerializedName("product_sets")
  private Object mProductSets = null;
  @SerializedName("product_type")
  private String mProductType = null;
  @SerializedName("quantity_to_sell_on_facebook")
  private Long mQuantityToSellOnFacebook = null;
  @SerializedName("retailer_id")
  private String mRetailerId = null;
  @SerializedName("retailer_product_group_id")
  private String mRetailerProductGroupId = null;
  @SerializedName("review_rejection_reasons")
  private List<String> mReviewRejectionReasons = null;
  @SerializedName("review_status")
  private String mReviewStatus = null;
  @SerializedName("rich_text_description")
  private String mRichTextDescription = null;
  @SerializedName("sale_price")
  private String mSalePrice = null;
  @SerializedName("sale_price_end_date")
  private String mSalePriceEndDate = null;
  @SerializedName("sale_price_start_date")
  private String mSalePriceStartDate = null;
  @SerializedName("shipping_weight_unit")
  private String mShippingWeightUnit = null;
  @SerializedName("shipping_weight_value")
  private Double mShippingWeightValue = null;
  @SerializedName("short_description")
  private String mShortDescription = null;
  @SerializedName("size")
  private String mSize = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("validation_errors")
  private Object mValidationErrors = null;
  @SerializedName("vendor_id")
  private String mVendorId = null;
  @SerializedName("video_fetch_status")
  private String mVideoFetchStatus = null;
  @SerializedName("videos")
  private List<Object> mVideos = null;
  @SerializedName("videos_metadata")
  private Object mVideosMetadata = null;
  @SerializedName("visibility")
  private String mVisibility = null;
  @SerializedName("wa_compliance_category")
  private String mWaComplianceCategory = null;
  protected static Gson gson = null;

  public ProductCatalogProductsPost() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductCatalogProductsPost loadJSON(String json, APIContext context, String header) {
    ProductCatalogProductsPost productCatalogProductsPost = getGson().fromJson(json, ProductCatalogProductsPost.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productCatalogProductsPost.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productCatalogProductsPost.context = context;
    productCatalogProductsPost.rawValue = json;
    productCatalogProductsPost.header = header;
    return productCatalogProductsPost;
  }

  public static APINodeList<ProductCatalogProductsPost> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductCatalogProductsPost> productCatalogProductsPosts = new APINodeList<ProductCatalogProductsPost>(request, json, header);
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
          productCatalogProductsPosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productCatalogProductsPosts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productCatalogProductsPosts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productCatalogProductsPosts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productCatalogProductsPosts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productCatalogProductsPosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productCatalogProductsPosts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productCatalogProductsPosts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productCatalogProductsPosts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productCatalogProductsPosts.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productCatalogProductsPosts;
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
              productCatalogProductsPosts.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productCatalogProductsPosts;
          }

          // Sixth, check if it's pure JsonObject
          productCatalogProductsPosts.clear();
          productCatalogProductsPosts.add(loadJSON(json, context, header));
          return productCatalogProductsPosts;
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


  public List<List<Object>> getFieldAdditionalImageCdnUrls() {
    return mAdditionalImageCdnUrls;
  }

  public ProductCatalogProductsPost setFieldAdditionalImageCdnUrls(List<List<Object>> value) {
    this.mAdditionalImageCdnUrls = value;
    return this;
  }

  public List<String> getFieldAdditionalImageUrls() {
    return mAdditionalImageUrls;
  }

  public ProductCatalogProductsPost setFieldAdditionalImageUrls(List<String> value) {
    this.mAdditionalImageUrls = value;
    return this;
  }

  public List<Object> getFieldAdditionalVariantAttributes() {
    return mAdditionalVariantAttributes;
  }

  public ProductCatalogProductsPost setFieldAdditionalVariantAttributes(List<Object> value) {
    this.mAdditionalVariantAttributes = value;
    return this;
  }

  public EnumAgeGroup getFieldAgeGroup() {
    return mAgeGroup;
  }

  public ProductCatalogProductsPost setFieldAgeGroup(EnumAgeGroup value) {
    this.mAgeGroup = value;
    return this;
  }

  public Object getFieldApplinks() {
    return mApplinks;
  }

  public ProductCatalogProductsPost setFieldApplinks(Object value) {
    this.mApplinks = value;
    return this;
  }

  public EnumAvailability getFieldAvailability() {
    return mAvailability;
  }

  public ProductCatalogProductsPost setFieldAvailability(EnumAvailability value) {
    this.mAvailability = value;
    return this;
  }

  public Long getFieldAvailableQuantityToSellOnFacebook() {
    return mAvailableQuantityToSellOnFacebook;
  }

  public ProductCatalogProductsPost setFieldAvailableQuantityToSellOnFacebook(Long value) {
    this.mAvailableQuantityToSellOnFacebook = value;
    return this;
  }

  public Long getFieldBaseCommissionRate() {
    return mBaseCommissionRate;
  }

  public ProductCatalogProductsPost setFieldBaseCommissionRate(Long value) {
    this.mBaseCommissionRate = value;
    return this;
  }

  public String getFieldBrand() {
    return mBrand;
  }

  public ProductCatalogProductsPost setFieldBrand(String value) {
    this.mBrand = value;
    return this;
  }

  public List<String> getFieldCapabilitiesDisabledByUser() {
    return mCapabilitiesDisabledByUser;
  }

  public ProductCatalogProductsPost setFieldCapabilitiesDisabledByUser(List<String> value) {
    this.mCapabilitiesDisabledByUser = value;
    return this;
  }

  public List<String> getFieldCapabilityFeatures() {
    return mCapabilityFeatures;
  }

  public ProductCatalogProductsPost setFieldCapabilityFeatures(List<String> value) {
    this.mCapabilityFeatures = value;
    return this;
  }

  public List<Object> getFieldCapabilityToReviewStatus() {
    return mCapabilityToReviewStatus;
  }

  public ProductCatalogProductsPost setFieldCapabilityToReviewStatus(List<Object> value) {
    this.mCapabilityToReviewStatus = value;
    return this;
  }

  public String getFieldCategory() {
    return mCategory;
  }

  public ProductCatalogProductsPost setFieldCategory(String value) {
    this.mCategory = value;
    return this;
  }

  public Map<Object, Object> getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
  }

  public ProductCatalogProductsPost setFieldCategorySpecificFields(Map<Object, Object> value) {
    this.mCategorySpecificFields = value;
    return this;
  }

  public Object getFieldChannelsToIntegrityStatus() {
    return mChannelsToIntegrityStatus;
  }

  public ProductCatalogProductsPost setFieldChannelsToIntegrityStatus(Object value) {
    this.mChannelsToIntegrityStatus = value;
    return this;
  }

  public String getFieldColor() {
    return mColor;
  }

  public ProductCatalogProductsPost setFieldColor(String value) {
    this.mColor = value;
    return this;
  }

  public Object getFieldCommerceInsights() {
    return mCommerceInsights;
  }

  public ProductCatalogProductsPost setFieldCommerceInsights(Object value) {
    this.mCommerceInsights = value;
    return this;
  }

  public EnumCondition getFieldCondition() {
    return mCondition;
  }

  public ProductCatalogProductsPost setFieldCondition(EnumCondition value) {
    this.mCondition = value;
    return this;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public ProductCatalogProductsPost setFieldCurrency(String value) {
    this.mCurrency = value;
    return this;
  }

  public List<Object> getFieldCustomData() {
    return mCustomData;
  }

  public ProductCatalogProductsPost setFieldCustomData(List<Object> value) {
    this.mCustomData = value;
    return this;
  }

  public String getFieldCustomLabel0() {
    return mCustomLabel0;
  }

  public ProductCatalogProductsPost setFieldCustomLabel0(String value) {
    this.mCustomLabel0 = value;
    return this;
  }

  public String getFieldCustomLabel1() {
    return mCustomLabel1;
  }

  public ProductCatalogProductsPost setFieldCustomLabel1(String value) {
    this.mCustomLabel1 = value;
    return this;
  }

  public String getFieldCustomLabel2() {
    return mCustomLabel2;
  }

  public ProductCatalogProductsPost setFieldCustomLabel2(String value) {
    this.mCustomLabel2 = value;
    return this;
  }

  public String getFieldCustomLabel3() {
    return mCustomLabel3;
  }

  public ProductCatalogProductsPost setFieldCustomLabel3(String value) {
    this.mCustomLabel3 = value;
    return this;
  }

  public String getFieldCustomLabel4() {
    return mCustomLabel4;
  }

  public ProductCatalogProductsPost setFieldCustomLabel4(String value) {
    this.mCustomLabel4 = value;
    return this;
  }

  public String getFieldCustomNumber0() {
    return mCustomNumber0;
  }

  public ProductCatalogProductsPost setFieldCustomNumber0(String value) {
    this.mCustomNumber0 = value;
    return this;
  }

  public String getFieldCustomNumber1() {
    return mCustomNumber1;
  }

  public ProductCatalogProductsPost setFieldCustomNumber1(String value) {
    this.mCustomNumber1 = value;
    return this;
  }

  public String getFieldCustomNumber2() {
    return mCustomNumber2;
  }

  public ProductCatalogProductsPost setFieldCustomNumber2(String value) {
    this.mCustomNumber2 = value;
    return this;
  }

  public String getFieldCustomNumber3() {
    return mCustomNumber3;
  }

  public ProductCatalogProductsPost setFieldCustomNumber3(String value) {
    this.mCustomNumber3 = value;
    return this;
  }

  public String getFieldCustomNumber4() {
    return mCustomNumber4;
  }

  public ProductCatalogProductsPost setFieldCustomNumber4(String value) {
    this.mCustomNumber4 = value;
    return this;
  }

  public String getFieldDaDisplayPreviewUrl() {
    return mDaDisplayPreviewUrl;
  }

  public ProductCatalogProductsPost setFieldDaDisplayPreviewUrl(String value) {
    this.mDaDisplayPreviewUrl = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public ProductCatalogProductsPost setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public List<Object> getFieldEnabledCapabilityToReviewStatus() {
    return mEnabledCapabilityToReviewStatus;
  }

  public ProductCatalogProductsPost setFieldEnabledCapabilityToReviewStatus(List<Object> value) {
    this.mEnabledCapabilityToReviewStatus = value;
    return this;
  }

  public List<Object> getFieldErrors() {
    return mErrors;
  }

  public ProductCatalogProductsPost setFieldErrors(List<Object> value) {
    this.mErrors = value;
    return this;
  }

  public String getFieldExpirationDate() {
    return mExpirationDate;
  }

  public ProductCatalogProductsPost setFieldExpirationDate(String value) {
    this.mExpirationDate = value;
    return this;
  }

  public String getFieldFbProductCategory() {
    return mFbProductCategory;
  }

  public ProductCatalogProductsPost setFieldFbProductCategory(String value) {
    this.mFbProductCategory = value;
    return this;
  }

  public EnumGender getFieldGender() {
    return mGender;
  }

  public ProductCatalogProductsPost setFieldGender(EnumGender value) {
    this.mGender = value;
    return this;
  }

  public String getFieldGtin() {
    return mGtin;
  }

  public ProductCatalogProductsPost setFieldGtin(String value) {
    this.mGtin = value;
    return this;
  }

  public Long getFieldId() {
    return mId;
  }

  public ProductCatalogProductsPost setFieldId(Long value) {
    this.mId = value;
    return this;
  }

  public List<Object> getFieldImageCdnUrls() {
    return mImageCdnUrls;
  }

  public ProductCatalogProductsPost setFieldImageCdnUrls(List<Object> value) {
    this.mImageCdnUrls = value;
    return this;
  }

  public String getFieldImageFetchStatus() {
    return mImageFetchStatus;
  }

  public ProductCatalogProductsPost setFieldImageFetchStatus(String value) {
    this.mImageFetchStatus = value;
    return this;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public ProductCatalogProductsPost setFieldImageUrl(String value) {
    this.mImageUrl = value;
    return this;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public ProductCatalogProductsPost setFieldImages(List<String> value) {
    this.mImages = value;
    return this;
  }

  public String getFieldImporterName() {
    return mImporterName;
  }

  public ProductCatalogProductsPost setFieldImporterName(String value) {
    this.mImporterName = value;
    return this;
  }

  public List<Object> getFieldInvalidationErrors() {
    return mInvalidationErrors;
  }

  public ProductCatalogProductsPost setFieldInvalidationErrors(List<Object> value) {
    this.mInvalidationErrors = value;
    return this;
  }

  public Long getFieldInventory() {
    return mInventory;
  }

  public ProductCatalogProductsPost setFieldInventory(Long value) {
    this.mInventory = value;
    return this;
  }

  public Boolean getFieldIsBundleHero() {
    return mIsBundleHero;
  }

  public ProductCatalogProductsPost setFieldIsBundleHero(Boolean value) {
    this.mIsBundleHero = value;
    return this;
  }

  public String getFieldManufacturerInfo() {
    return mManufacturerInfo;
  }

  public ProductCatalogProductsPost setFieldManufacturerInfo(String value) {
    this.mManufacturerInfo = value;
    return this;
  }

  public String getFieldManufacturerPartNumber() {
    return mManufacturerPartNumber;
  }

  public ProductCatalogProductsPost setFieldManufacturerPartNumber(String value) {
    this.mManufacturerPartNumber = value;
    return this;
  }

  public String getFieldMaterial() {
    return mMaterial;
  }

  public ProductCatalogProductsPost setFieldMaterial(String value) {
    this.mMaterial = value;
    return this;
  }

  public String getFieldMobileLink() {
    return mMobileLink;
  }

  public ProductCatalogProductsPost setFieldMobileLink(String value) {
    this.mMobileLink = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public ProductCatalogProductsPost setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Long getFieldOrderingIndex() {
    return mOrderingIndex;
  }

  public ProductCatalogProductsPost setFieldOrderingIndex(Long value) {
    this.mOrderingIndex = value;
    return this;
  }

  public String getFieldOriginCountry() {
    return mOriginCountry;
  }

  public ProductCatalogProductsPost setFieldOriginCountry(String value) {
    this.mOriginCountry = value;
    return this;
  }

  public Object getFieldOverrideDetails() {
    return mOverrideDetails;
  }

  public ProductCatalogProductsPost setFieldOverrideDetails(Object value) {
    this.mOverrideDetails = value;
    return this;
  }

  public String getFieldPattern() {
    return mPattern;
  }

  public ProductCatalogProductsPost setFieldPattern(String value) {
    this.mPattern = value;
    return this;
  }

  public Boolean getFieldPostConversionSignalBasedEnforcementAppealEligibility() {
    return mPostConversionSignalBasedEnforcementAppealEligibility;
  }

  public ProductCatalogProductsPost setFieldPostConversionSignalBasedEnforcementAppealEligibility(Boolean value) {
    this.mPostConversionSignalBasedEnforcementAppealEligibility = value;
    return this;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public ProductCatalogProductsPost setFieldPrice(String value) {
    this.mPrice = value;
    return this;
  }

  public Object getFieldProductCatalog() {
    return mProductCatalog;
  }

  public ProductCatalogProductsPost setFieldProductCatalog(Object value) {
    this.mProductCatalog = value;
    return this;
  }

  public Object getFieldProductFeed() {
    return mProductFeed;
  }

  public ProductCatalogProductsPost setFieldProductFeed(Object value) {
    this.mProductFeed = value;
    return this;
  }

  public Object getFieldProductGroup() {
    return mProductGroup;
  }

  public ProductCatalogProductsPost setFieldProductGroup(Object value) {
    this.mProductGroup = value;
    return this;
  }

  public Double getFieldProductPriority0() {
    return mProductPriority0;
  }

  public ProductCatalogProductsPost setFieldProductPriority0(Double value) {
    this.mProductPriority0 = value;
    return this;
  }

  public Double getFieldProductPriority1() {
    return mProductPriority1;
  }

  public ProductCatalogProductsPost setFieldProductPriority1(Double value) {
    this.mProductPriority1 = value;
    return this;
  }

  public Double getFieldProductPriority2() {
    return mProductPriority2;
  }

  public ProductCatalogProductsPost setFieldProductPriority2(Double value) {
    this.mProductPriority2 = value;
    return this;
  }

  public Double getFieldProductPriority3() {
    return mProductPriority3;
  }

  public ProductCatalogProductsPost setFieldProductPriority3(Double value) {
    this.mProductPriority3 = value;
    return this;
  }

  public Double getFieldProductPriority4() {
    return mProductPriority4;
  }

  public ProductCatalogProductsPost setFieldProductPriority4(Double value) {
    this.mProductPriority4 = value;
    return this;
  }

  public String getFieldProductRelationship() {
    return mProductRelationship;
  }

  public ProductCatalogProductsPost setFieldProductRelationship(String value) {
    this.mProductRelationship = value;
    return this;
  }

  public Object getFieldProductSets() {
    return mProductSets;
  }

  public ProductCatalogProductsPost setFieldProductSets(Object value) {
    this.mProductSets = value;
    return this;
  }

  public String getFieldProductType() {
    return mProductType;
  }

  public ProductCatalogProductsPost setFieldProductType(String value) {
    this.mProductType = value;
    return this;
  }

  public Long getFieldQuantityToSellOnFacebook() {
    return mQuantityToSellOnFacebook;
  }

  public ProductCatalogProductsPost setFieldQuantityToSellOnFacebook(Long value) {
    this.mQuantityToSellOnFacebook = value;
    return this;
  }

  public String getFieldRetailerId() {
    return mRetailerId;
  }

  public ProductCatalogProductsPost setFieldRetailerId(String value) {
    this.mRetailerId = value;
    return this;
  }

  public String getFieldRetailerProductGroupId() {
    return mRetailerProductGroupId;
  }

  public ProductCatalogProductsPost setFieldRetailerProductGroupId(String value) {
    this.mRetailerProductGroupId = value;
    return this;
  }

  public List<String> getFieldReviewRejectionReasons() {
    return mReviewRejectionReasons;
  }

  public ProductCatalogProductsPost setFieldReviewRejectionReasons(List<String> value) {
    this.mReviewRejectionReasons = value;
    return this;
  }

  public String getFieldReviewStatus() {
    return mReviewStatus;
  }

  public ProductCatalogProductsPost setFieldReviewStatus(String value) {
    this.mReviewStatus = value;
    return this;
  }

  public String getFieldRichTextDescription() {
    return mRichTextDescription;
  }

  public ProductCatalogProductsPost setFieldRichTextDescription(String value) {
    this.mRichTextDescription = value;
    return this;
  }

  public String getFieldSalePrice() {
    return mSalePrice;
  }

  public ProductCatalogProductsPost setFieldSalePrice(String value) {
    this.mSalePrice = value;
    return this;
  }

  public String getFieldSalePriceEndDate() {
    return mSalePriceEndDate;
  }

  public ProductCatalogProductsPost setFieldSalePriceEndDate(String value) {
    this.mSalePriceEndDate = value;
    return this;
  }

  public String getFieldSalePriceStartDate() {
    return mSalePriceStartDate;
  }

  public ProductCatalogProductsPost setFieldSalePriceStartDate(String value) {
    this.mSalePriceStartDate = value;
    return this;
  }

  public String getFieldShippingWeightUnit() {
    return mShippingWeightUnit;
  }

  public ProductCatalogProductsPost setFieldShippingWeightUnit(String value) {
    this.mShippingWeightUnit = value;
    return this;
  }

  public Double getFieldShippingWeightValue() {
    return mShippingWeightValue;
  }

  public ProductCatalogProductsPost setFieldShippingWeightValue(Double value) {
    this.mShippingWeightValue = value;
    return this;
  }

  public String getFieldShortDescription() {
    return mShortDescription;
  }

  public ProductCatalogProductsPost setFieldShortDescription(String value) {
    this.mShortDescription = value;
    return this;
  }

  public String getFieldSize() {
    return mSize;
  }

  public ProductCatalogProductsPost setFieldSize(String value) {
    this.mSize = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public ProductCatalogProductsPost setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public ProductCatalogProductsPost setFieldTags(List<String> value) {
    this.mTags = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public ProductCatalogProductsPost setFieldUrl(String value) {
    this.mUrl = value;
    return this;
  }

  public Object getFieldValidationErrors() {
    return mValidationErrors;
  }

  public ProductCatalogProductsPost setFieldValidationErrors(Object value) {
    this.mValidationErrors = value;
    return this;
  }

  public String getFieldVendorId() {
    return mVendorId;
  }

  public ProductCatalogProductsPost setFieldVendorId(String value) {
    this.mVendorId = value;
    return this;
  }

  public String getFieldVideoFetchStatus() {
    return mVideoFetchStatus;
  }

  public ProductCatalogProductsPost setFieldVideoFetchStatus(String value) {
    this.mVideoFetchStatus = value;
    return this;
  }

  public List<Object> getFieldVideos() {
    return mVideos;
  }

  public ProductCatalogProductsPost setFieldVideos(List<Object> value) {
    this.mVideos = value;
    return this;
  }

  public Object getFieldVideosMetadata() {
    return mVideosMetadata;
  }

  public ProductCatalogProductsPost setFieldVideosMetadata(Object value) {
    this.mVideosMetadata = value;
    return this;
  }

  public String getFieldVisibility() {
    return mVisibility;
  }

  public ProductCatalogProductsPost setFieldVisibility(String value) {
    this.mVisibility = value;
    return this;
  }

  public String getFieldWaComplianceCategory() {
    return mWaComplianceCategory;
  }

  public ProductCatalogProductsPost setFieldWaComplianceCategory(String value) {
    this.mWaComplianceCategory = value;
    return this;
  }



  public static enum EnumAgeGroup {
      @SerializedName("ADULT")
      VALUE_ADULT("ADULT"),
      @SerializedName("ALL_AGES")
      VALUE_ALL_AGES("ALL_AGES"),
      @SerializedName("INFANT")
      VALUE_INFANT("INFANT"),
      @SerializedName("KIDS")
      VALUE_KIDS("KIDS"),
      @SerializedName("NEWBORN")
      VALUE_NEWBORN("NEWBORN"),
      @SerializedName("TEEN")
      VALUE_TEEN("TEEN"),
      @SerializedName("TODDLER")
      VALUE_TODDLER("TODDLER"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      ;

      private String value;

      private EnumAgeGroup(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAvailability {
      @SerializedName("AVAILABLE_FOR_ORDER")
      VALUE_AVAILABLE_FOR_ORDER("AVAILABLE_FOR_ORDER"),
      @SerializedName("DISCONTINUED")
      VALUE_DISCONTINUED("DISCONTINUED"),
      @SerializedName("IN_STOCK")
      VALUE_IN_STOCK("IN_STOCK"),
      @SerializedName("MARK_AS_EXPIRED")
      VALUE_MARK_AS_EXPIRED("MARK_AS_EXPIRED"),
      @SerializedName("MARK_AS_SOLD")
      VALUE_MARK_AS_SOLD("MARK_AS_SOLD"),
      @SerializedName("OUT_OF_STOCK")
      VALUE_OUT_OF_STOCK("OUT_OF_STOCK"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("PREORDER")
      VALUE_PREORDER("PREORDER"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      ;

      private String value;

      private EnumAvailability(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCondition {
      @SerializedName("PC_CPO")
      VALUE_PC_CPO("PC_CPO"),
      @SerializedName("PC_NEW")
      VALUE_PC_NEW("PC_NEW"),
      @SerializedName("PC_OPEN_BOX_NEW")
      VALUE_PC_OPEN_BOX_NEW("PC_OPEN_BOX_NEW"),
      @SerializedName("PC_REFURBISHED")
      VALUE_PC_REFURBISHED("PC_REFURBISHED"),
      @SerializedName("PC_USED")
      VALUE_PC_USED("PC_USED"),
      @SerializedName("PC_USED_FAIR")
      VALUE_PC_USED_FAIR("PC_USED_FAIR"),
      @SerializedName("PC_USED_GOOD")
      VALUE_PC_USED_GOOD("PC_USED_GOOD"),
      @SerializedName("PC_USED_LIKE_NEW")
      VALUE_PC_USED_LIKE_NEW("PC_USED_LIKE_NEW"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      ;

      private String value;

      private EnumCondition(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumGender {
      @SerializedName("FEMALE")
      VALUE_FEMALE("FEMALE"),
      @SerializedName("MALE")
      VALUE_MALE("MALE"),
      @SerializedName("UNISEX")
      VALUE_UNISEX("UNISEX"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      ;

      private String value;

      private EnumGender(String value) {
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

  public ProductCatalogProductsPost copyFrom(ProductCatalogProductsPost instance) {
    this.mAdditionalImageCdnUrls = instance.mAdditionalImageCdnUrls;
    this.mAdditionalImageUrls = instance.mAdditionalImageUrls;
    this.mAdditionalVariantAttributes = instance.mAdditionalVariantAttributes;
    this.mAgeGroup = instance.mAgeGroup;
    this.mApplinks = instance.mApplinks;
    this.mAvailability = instance.mAvailability;
    this.mAvailableQuantityToSellOnFacebook = instance.mAvailableQuantityToSellOnFacebook;
    this.mBaseCommissionRate = instance.mBaseCommissionRate;
    this.mBrand = instance.mBrand;
    this.mCapabilitiesDisabledByUser = instance.mCapabilitiesDisabledByUser;
    this.mCapabilityFeatures = instance.mCapabilityFeatures;
    this.mCapabilityToReviewStatus = instance.mCapabilityToReviewStatus;
    this.mCategory = instance.mCategory;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mChannelsToIntegrityStatus = instance.mChannelsToIntegrityStatus;
    this.mColor = instance.mColor;
    this.mCommerceInsights = instance.mCommerceInsights;
    this.mCondition = instance.mCondition;
    this.mCurrency = instance.mCurrency;
    this.mCustomData = instance.mCustomData;
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
    this.mEnabledCapabilityToReviewStatus = instance.mEnabledCapabilityToReviewStatus;
    this.mErrors = instance.mErrors;
    this.mExpirationDate = instance.mExpirationDate;
    this.mFbProductCategory = instance.mFbProductCategory;
    this.mGender = instance.mGender;
    this.mGtin = instance.mGtin;
    this.mId = instance.mId;
    this.mImageCdnUrls = instance.mImageCdnUrls;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImageUrl = instance.mImageUrl;
    this.mImages = instance.mImages;
    this.mImporterName = instance.mImporterName;
    this.mInvalidationErrors = instance.mInvalidationErrors;
    this.mInventory = instance.mInventory;
    this.mIsBundleHero = instance.mIsBundleHero;
    this.mManufacturerInfo = instance.mManufacturerInfo;
    this.mManufacturerPartNumber = instance.mManufacturerPartNumber;
    this.mMaterial = instance.mMaterial;
    this.mMobileLink = instance.mMobileLink;
    this.mName = instance.mName;
    this.mOrderingIndex = instance.mOrderingIndex;
    this.mOriginCountry = instance.mOriginCountry;
    this.mOverrideDetails = instance.mOverrideDetails;
    this.mPattern = instance.mPattern;
    this.mPostConversionSignalBasedEnforcementAppealEligibility = instance.mPostConversionSignalBasedEnforcementAppealEligibility;
    this.mPrice = instance.mPrice;
    this.mProductCatalog = instance.mProductCatalog;
    this.mProductFeed = instance.mProductFeed;
    this.mProductGroup = instance.mProductGroup;
    this.mProductPriority0 = instance.mProductPriority0;
    this.mProductPriority1 = instance.mProductPriority1;
    this.mProductPriority2 = instance.mProductPriority2;
    this.mProductPriority3 = instance.mProductPriority3;
    this.mProductPriority4 = instance.mProductPriority4;
    this.mProductRelationship = instance.mProductRelationship;
    this.mProductSets = instance.mProductSets;
    this.mProductType = instance.mProductType;
    this.mQuantityToSellOnFacebook = instance.mQuantityToSellOnFacebook;
    this.mRetailerId = instance.mRetailerId;
    this.mRetailerProductGroupId = instance.mRetailerProductGroupId;
    this.mReviewRejectionReasons = instance.mReviewRejectionReasons;
    this.mReviewStatus = instance.mReviewStatus;
    this.mRichTextDescription = instance.mRichTextDescription;
    this.mSalePrice = instance.mSalePrice;
    this.mSalePriceEndDate = instance.mSalePriceEndDate;
    this.mSalePriceStartDate = instance.mSalePriceStartDate;
    this.mShippingWeightUnit = instance.mShippingWeightUnit;
    this.mShippingWeightValue = instance.mShippingWeightValue;
    this.mShortDescription = instance.mShortDescription;
    this.mSize = instance.mSize;
    this.mStatus = instance.mStatus;
    this.mTags = instance.mTags;
    this.mUrl = instance.mUrl;
    this.mValidationErrors = instance.mValidationErrors;
    this.mVendorId = instance.mVendorId;
    this.mVideoFetchStatus = instance.mVideoFetchStatus;
    this.mVideos = instance.mVideos;
    this.mVideosMetadata = instance.mVideosMetadata;
    this.mVisibility = instance.mVisibility;
    this.mWaComplianceCategory = instance.mWaComplianceCategory;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductCatalogProductsPost> getParser() {
    return new APIRequest.ResponseParser<ProductCatalogProductsPost>() {
      public APINodeList<ProductCatalogProductsPost> parseResponse(String response, APIContext context, APIRequest<ProductCatalogProductsPost> request, String header) throws MalformedResponseException {
        return ProductCatalogProductsPost.parseResponse(response, context, request, header);
      }
    };
  }
}
