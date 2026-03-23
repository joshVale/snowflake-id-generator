package io.maksymdobrynin.snowflakegenerator

import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
class SnowflakeController(
	private val generator: Generator,
	private val settings: GeneratorSettings,
	private val repository: SnowflakeRecordRepository,
) {
	@GetMapping("/next-id")
	fun generate(): Long = runBlocking {
		val id = generator.nextId()
		repository.save(
			SnowflakeRecord(
				guid = id,
				createdAt = Instant.now(),
				datacenterId = settings.datacenterId,
				workedId = settings.workedId,
			),
		)
		id
	}
}
