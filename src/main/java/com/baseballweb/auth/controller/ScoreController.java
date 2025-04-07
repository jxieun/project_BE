@RestController
@RequestMapping("/api/score")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    // 점수 제출
    @PostMapping("/submit")
    public ResponseEntity<ScoreDTO> submitScore(@RequestBody ScoreDTO scoreDTO) {
        ScoreDTO updatedScore = scoreService.addScore(scoreDTO);
        return ResponseEntity.ok(updatedScore);
    }

    // 팬 랭킹 조회
    @GetMapping("/ranking")
    public ResponseEntity<List<FanDTO>> getTopFans() {
        List<FanDTO> topFans = scoreService.getTopFans();
        return ResponseEntity.ok(topFans);
    }
}