package cn.sigmon.incometax.util;

/**
 * IncomeTaxCalculator
 *
 * @author $USER_NAME
 * @date 2018/12/27 10:20 PM
 */
public class IncomeTaxCalculator {
    private final float FREE_NUMBER = 5000f;  // 免征额
    private float mBaseSalary = 0f;  // 税前收入
    private float mBaseNumber = 0f;  // 应税收入（ = 税前收入 - 免征额 - 专项附加扣除 - 住房公积金个人部分）
    private HousingFundCalculator mFundCalculator;
    private SocialSecurityCalculator mSSCalculator;
    private TaxRate mTaxRate;

    public IncomeTaxCalculator(float baseSalary) {
        mBaseSalary = baseSalary;

        mFundCalculator = new HousingFundCalculator(mBaseSalary, 0.12f);
        mSSCalculator = new SocialSecurityCalculator(mBaseSalary);

        mBaseNumber = mBaseSalary - FREE_NUMBER - mSSCalculator.getPersonalPart() - mFundCalculator.getRealityPersonalPart();
        mTaxRate = new TaxRate(mBaseNumber);
    }

    public float getIncomeTax() {
        return mTaxRate.getTax();
    }
}
