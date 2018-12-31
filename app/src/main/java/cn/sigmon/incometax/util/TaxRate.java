package cn.sigmon.incometax.util;

/**
 * TaxRate
 *
 * @author $USER_NAME
 * @date 2018/12/27 10:32 PM
 */
public class TaxRate {
    private final float mBaseNumber;   // 应税收入(扣除免税额之后的)

    public TaxRate(float baseNumber) {
        mBaseNumber = baseNumber;
    }

    private TaxRateLevel level(float baseNumber) {
        if (baseNumber <= 0) {
            return TaxRateLevel.zero;
        } else if (baseNumber <= 3000) {
            return TaxRateLevel.one;
        } else if (baseNumber <= 12000) {
            return TaxRateLevel.two;
        } else if (baseNumber <= 25000) {
            return TaxRateLevel.three;
        } else if (baseNumber <= 35000) {
            return TaxRateLevel.four;
        } else if (baseNumber <= 55000) {
            return TaxRateLevel.five;
        } else if (baseNumber <= 80000) {
            return TaxRateLevel.six;
        } else {
            return TaxRateLevel.seven;
        }
    }

    public float getTax() {
        TaxRateLevel level = level(mBaseNumber);
        return mBaseNumber * level.rate - level.number;
    }

    public enum TaxRateLevel {
        zero(0f, 0f),
        one(0.03f, 0f),
        two(0.1f, 210f),
        three(0.2f, 14100f),
        four(0.25f, 2660f),
        five(0.3f, 4410f),
        six(0.35f, 7160f),
        seven(0.45f, 15160f);

        private float rate;
        private float number;

        TaxRateLevel(float r, float n) {
            rate = r;
            number = n;
        }
    }
}
