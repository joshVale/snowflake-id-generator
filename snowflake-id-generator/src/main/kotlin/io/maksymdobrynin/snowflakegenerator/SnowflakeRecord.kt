package io.maksymdobrynin.snowflakegenerator

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "snowflake_records")
open class SnowflakeRecord(
	@Id
	@Column(name = "guid")
	open var guid: Long = 0,

	@Column(name = "created_at", nullable = false)
	open var createdAt: Instant = Instant.now(),

	@Column(name = "datacenter_id", nullable = false)
	open var datacenterId: Long = 0,

	@Column(name = "worked_id", nullable = false)
	open var workedId: Long = 0,
)
