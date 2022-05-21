package aehdb.chat.room.model.dto;

import java.util.UUID;

import javax.persistence.Convert;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import aehdb.comm.model.converter.TFCode;
import aehdb.comm.model.converter.TFCodeConverter;
import aehdb.mng.legacy.model.dto.LegacyDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto {
	private Long id;
	private UUID roomUuid;
	@NotEmpty(message = "errors.required")
	@Size(min = 1, max = 50, message = "errors.range")
	private String roomNm;
	@Convert(converter = TFCodeConverter.class)
	private TFCode isClosed = TFCode.FALSE;
	private LegacyDto legacyDto;
}

// 문제가 뭐냐면 내부 어플리케이션일 때는 화면에서 pk를 암
// 근데 연계 시스템인 경우에는 pk를 알려주거나?
// pk가 아닌 unique key를 알려줘야할 것 같은 기분?
// 근데 또 어차피 내부 어플리케이션에서도 json으로 다 볼 수 있긴한데,, 하씨..