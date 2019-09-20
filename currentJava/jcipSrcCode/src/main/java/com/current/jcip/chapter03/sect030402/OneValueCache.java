package com.current.jcip.chapter03.sect030402;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 054_3.4.2_srcCode_？？？！！！_使用volatile和final发布不可变对象_实现因数分解无需synchronized
 *
 */
public class OneValueCache {
    private final BigInteger lastNumber; // 为什么使用final?不使用final有没有问题? 答:final可以保证构造函数完成后，引用才被其他线程可见(参见 读写final字段的重排序规则)
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        this.lastNumber = i;
        this.lastFactors = Arrays.copyOf(factors,factors.length);//实例封闭
    }

    public BigInteger[] getFactors(BigInteger i){
        if(lastNumber == null || !lastNumber.equals(i)){
            return null;
        }else
            return Arrays.copyOf(lastFactors,lastFactors.length); //为什么需要复制？ 答:实例封闭。否则此引用会出现方法逃逸
    }
}
