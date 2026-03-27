{{- define "postgres.labels" -}}
app: postgres
app.kubernetes.io/name: postgres
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{- define "postgres.selectorLabels" -}}
app: postgres
{{- end }}
