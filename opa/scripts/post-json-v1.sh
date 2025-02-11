curl -v -X POST "http://localhost:8181/v1/data/grc/image/validation/deny?metrics" \
	--http1.1 \
	-H 'Content-Type: application/json' \
	-H 'Accept: application/json' \
    -d @input/input-v1.json