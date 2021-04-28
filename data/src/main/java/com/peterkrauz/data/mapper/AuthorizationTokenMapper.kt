package com.peterkrauz.data.mapper

import com.peterkrauz.data.dto.AuthorizationTokenDto
import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.domain.mapper.Mapper

class AuthorizationTokenMapper : Mapper<AuthorizationTokenDto, AuthorizationToken> {
    override fun map(dto: AuthorizationTokenDto): AuthorizationToken {
        return AuthorizationToken(
            dto.authToken
        )
    }
}
