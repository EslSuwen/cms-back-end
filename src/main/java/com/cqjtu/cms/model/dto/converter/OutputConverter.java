package com.cqjtu.cms.model.dto.converter;

/**
 * Converter interface for output DTO.
 *
 * @author johnniang
 * @date 11/27/18
 */
public interface OutputConverter<DTO, DOMAIN> {

    /**
     * Convert from domain.
     *
     * @param domain domain data
     * @return converted dto data
     */
    DTO convertFrom(DOMAIN domain);
}
