package com.avaliacao.util;

import java.io.IOException;

import com.avaliacao.models.Documento;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DocumentoSerializer extends StdSerializer<Documento>{
	
	protected DocumentoSerializer() {
		this(null);
	}

	protected DocumentoSerializer(Class<Documento> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(Documento value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("tipoDocumento", value.getTipoDocumento());
        gen.writeStringField("descricao", value.getDescricao());
        gen.writeStringField("dataInclusao", value.getDataInclusao().toString());
        gen.writeStringField("dataAtualizacao", value.getDataAtualizacao().toString());
        gen.writeEndObject();		
	}
}
