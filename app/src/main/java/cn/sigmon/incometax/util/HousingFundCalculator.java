package cn.sigmon.incometax.util;

/**
 * HousingFundCalculator
 *
 * @author $USER_NAME
 * @date 2018/12/27 10:28 PM
 */
public class HousingFundCalculator {
    private final float mBaseNumber;  // 公积金基数
    private float mRate = 0f;    // 公积金比例

    private float mStandardCompanyPart = 0f;
    private float mStandardPersonalPart = 0f;
    private float mRealityCompanyPart = 0f;
    private float mRealityPersonalPart = 0f;

    public HousingFundCalculator(float baseNumber) {
        mBaseNumber = baseNumber;
    }

    public HousingFundCalculator(float baseNumber, float rate) {
        mBaseNumber = baseNumber;

        setRate(rate);
    }

    public void setRate(float rate) {
        mRate = rate;

        mStandardCompanyPart = mBaseNumber * mRate;
        mRealityCompanyPart = mStandardCompanyPart;
        mStandardPersonalPart = mBaseNumber * mRate;
        mRealityPersonalPart = mStandardPersonalPart;
    }

    public void setRealityCompanyPart(float realityCompanyPart) {
        mRealityCompanyPart = realityCompanyPart;
    }

    public void setRealityPersonalPart(float realityPersonalPart) {
        mRealityPersonalPart = realityPersonalPart;
    }

    public float getRealityPersonalPart() {
        return mRealityPersonalPart + getDebts();
    }

    private float getDebts() {
        return mRealityCompanyPart - mStandardPersonalPart;
    }
}
