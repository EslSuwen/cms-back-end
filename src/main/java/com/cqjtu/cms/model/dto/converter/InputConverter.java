package com.cqjtu.cms.model.dto.converter;

/**
 * Converter interface for input DTO.
 *
 * @author johnniang
 */
public interface InputConverter<DOMAIN> {

    /**
     * Convert to domain.
     *
     * @return new domain with same value(not null)
     */
    DOMAIN convertTo();

    /**
     * Update a domain by dto.
     *
     * @param domain updated domain
     */
    void update(DOMAIN domain);
}

