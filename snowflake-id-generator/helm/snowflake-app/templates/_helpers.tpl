{{- define "snowflake.labels" -}}
app: {{ .Chart.Name }}
app.kubernetes.io/name: {{ .Chart.Name }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{- define "snowflake.selectorLabels" -}}
app: {{ .Chart.Name }}
{{- end }}

{{- define "postgres.labels" -}}
app: postgres
{{- end }}
