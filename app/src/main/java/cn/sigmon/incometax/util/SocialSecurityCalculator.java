package cn.sigmon.incometax.util;

/**
 * SocialSecurityCalculator
 *
 * @author $USER_NAME
 * @date 2018/12/27 10:23 PM
 */
public class SocialSecurityCalculator {
    private final float mBaseNumber;

    private float mCompanyPart = 0f;
    private float mPersonalPart = 0f;

    public SocialSecurityCalculator(float baseNumber) {
        mBaseNumber = baseNumber;

        mPersonalPart = mBaseNumber * (0.02f + 0.08f + 0.002f);
    }

    public float getCompanyPart() {
        return mCompanyPart;
    }

    public float getPersonalPart() {
        return mPersonalPart;
    }
}
