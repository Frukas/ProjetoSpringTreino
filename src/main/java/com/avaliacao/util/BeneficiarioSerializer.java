package com.avaliacao.util;

import java.io.IOException;

import com.avaliacao.models.Beneficiario;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/*
 * Class responsible for a custom json convertion of beneficiario 
 * without documentos fields.
 * */
public class BeneficiarioSerializer extends StdSerializer<Beneficiario> {

	protected BeneficiarioSerializer() {
		this(null);
	}
	
	protected BeneficiarioSerializer(Class<Beneficiario> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(Beneficiario value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("nome", value.getNome());
        gen.writeStringField("telefone", value.getTelefone());
        gen.writeStringField("dataNascimento", value.getDataNascimento());
        gen.writeStringField("dataInclusao", value.getDataInclusao().toString());
        gen.writeStringField("dataAtualizacao", value.getDataAtualizacao().toString());
        gen.writeEndObject();		
	}
}
