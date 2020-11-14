package com.cqjtu.cms.model.dto.converter;

import com.cqjtu.cms.util.BeanUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author johnniang
 * @classname AbstractInputConverter
 * @description Convenience for input dto.
 * @date 11/27/18
 */
public abstract class AbstractInputConverter<DOMAIN>   implements Serializable,InputConverter<DOMAIN> {

    private static final long serialVersionUID = 3340351915345559222L;
    private final Class<DOMAIN> domainType = (Class<DOMAIN>) fetchType(0);

    @Override
    public DOMAIN convertTo() {
        return BeanUtils.transfrom(domainType, this);
    }

    @Override
    public void update(DOMAIN domain) {
        BeanUtils.update(this, domain);
    }

    /**
     * Get actual generic type.
     *
     * @param index generic type index
     * @return real type will be returned
     */
    private Type fetchType(int index) {
        return ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[index];
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
