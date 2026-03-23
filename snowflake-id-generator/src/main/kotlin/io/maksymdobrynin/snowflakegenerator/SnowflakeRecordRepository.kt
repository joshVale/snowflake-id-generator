package io.maksymdobrynin.snowflakegenerator

import org.springframework.data.jpa.repository.JpaRepository

interface SnowflakeRecordRepository : JpaRepository<SnowflakeRecord, Long>
