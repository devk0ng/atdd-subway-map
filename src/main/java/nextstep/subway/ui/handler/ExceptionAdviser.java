package nextstep.subway.ui.handler;

import nextstep.subway.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviser {

    @ExceptionHandler(LineNotFoundException.class)
    public ResponseEntity<Void> lineNotFoundHandler(LineNotFoundException exception) {
        return ResponseEntity.notFound()
                .build();
    }

    @ExceptionHandler({
            DuplicateStationException.class,
            AlreadyRegisteredStationInLineException.class,
            DownStationNotMatchException.class,
            DuplicateLineException.class,
            MinimumSectionException.class,
            DeleteLastDownStationException.class})
    public ResponseEntity<ErrorResponse> duplicateStationHandler(RuntimeException exception) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(exception.getMessage()));
    }

}
