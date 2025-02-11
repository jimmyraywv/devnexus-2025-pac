curl -v -X POST "http://localhost:8181/v1/data/grc/image/validation/deny?metrics" \
	--http1.1 \
	-H 'Content-Type: application/x-yaml' \
	-H 'Accept: application/json' \
    --data-binary @input/input-v1.yaml