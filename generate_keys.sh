#!/bin/bash
# Script para gerar par de chaves RSA e extrair a chave pública DER em Base64 para uso no application.properties

# 1. Gerar chave privada
openssl genpkey -algorithm RSA -out private_key.pem -pkeyopt rsa_keygen_bits:2048

# 2. Extrair chave pública PEM
openssl rsa -in private_key.pem -pubout -out public_key.pem

# 3. Converter chave pública PEM para DER
openssl rsa -pubin -in public_key.pem -outform DER -out public_key.der

# 4. Converter DER para Base64 (uma linha só)
base64 -w 0 public_key.der > public_key.der.b64

echo "Arquivo public_key.der.b64 gerado. Copie o conteúdo para o application.properties."
