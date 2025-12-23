package io.woorinpang.assetservice.core.api.controller.asset

import com.fasterxml.jackson.module.kotlin.jsonMapper
import io.mockk.every
import io.mockk.mockk
import io.woorinpang.assetservice.core.api.config.AuthenticatedUser
import io.woorinpang.assetservice.core.api.controller.asset.request.AppendAssetRequest
import io.woorinpang.assetservice.core.domain.asset.Asset
import io.woorinpang.assetservice.core.domain.asset.AssetService
import io.woorinpang.assetservice.core.enums.AssetType
import io.woorinpang.assetservice.tests.api.docs.RestDocsTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.operation.preprocess.Preprocessors
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDateTime

class AssetControllerTest : RestDocsTest() {
    private lateinit var assetService: AssetService
    private lateinit var controller: AssetController

    @BeforeEach
    fun setUp() {
        assetService = mockk()
        controller = AssetController(assetService)
        mockMvc = mockController(controller)
    }

    @DisplayName("자산등록하면 상태코드 200과 AppendAssetResponse 객체를 반환한다")
    @Test
    fun appendAssetTest() {
        every { assetService.appendAsset(any(), any()) } returns 1
        val authenticatedUser = AuthenticatedUser(1, "heechul@google.com", "희철", "USER")

        mockMvc.perform(
            post("/v1/assets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper().writeValueAsString(AppendAssetRequest("ELECTRONIC")))

        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "post-v1-assets",
                    Preprocessors.preprocessRequest(Preprocessors.prettyPrint()),
                    Preprocessors.preprocessResponse(Preprocessors.prettyPrint()),
                    requestFields(
                        fieldWithPath("assetType").type(JsonFieldType.STRING).description("asset 유형"),
                    ),
                    responseFields(
                        fieldWithPath("result").type(JsonFieldType.STRING).description("SUCCESS/ERROR"),
                        fieldWithPath("data.id").type(JsonFieldType.NUMBER).description("추가된 고유번호"),
                        fieldWithPath("error").type(JsonFieldType.STRING).ignored().description("에러"),
                    )
                )
            )
    }

//    @DisplayName("자산을 조회하면 상태코드 200과 FindAssetResponse 객체를 반환한다")
//    @Test
    fun findAssetTest() {
        every { assetService.findAsset(any()) } returns Asset.of(1, 1, AssetType.ELECTRONIC, "dev.heechul@gmail.com", LocalDateTime.now(), false)

//        given()
//            .contentType(ContentType.JSON)
//            .get("/assets/{assetId}", "1")
//            .then()
//            .status(HttpStatus.OK)
//            .apply(
//                document(
//                    "find-asset",
//                    requestPreprocessor(),
//                    responsePreprocessor(),
//                    RequestDocumentation.pathParameters(
//                        parameterWithName("assetId").description("자산 고유번호"),
//                    ),
//                    responseFields(
//                        fieldWithPath("result").type(JsonFieldType.STRING).description("ResultType"),
//                        fieldWithPath("data.assetId").type(JsonFieldType.NUMBER).description("자산 고유번호"),
//                        fieldWithPath("data.userId").type(JsonFieldType.NUMBER).description("사용자 고유번호"),
//                        fieldWithPath("data.assetType").type(JsonFieldType.STRING).description("자산 유형"),
//                        fieldWithPath("data.assetTypeDescription").type(JsonFieldType.STRING).description("자사 유형 설명"),
//                        fieldWithPath("error").type(JsonFieldType.STRING).ignored(),
//                    ),
//                ),
//            )
    }

//    @DisplayName("자산을 삭제하면 상태코드 200을 반환한다.")
//    @Test
    fun deleteAssetTest() {
        every { assetService.deleteAsset(any(), any()) }

//        given()
//            .contentType(ContentType.JSON)
//            .delete("/assets/{assetId}", "1")
//            .then()
//            .status(HttpStatus.OK)
//            .apply(
//                document(
//                    "delete-asset",
//                    requestPreprocessor(),
//                    responsePreprocessor(),
//                    RequestDocumentation.pathParameters(
//                        parameterWithName("assetId").description("자산 고유번호"),
//                    ),
//                    responseFields(
//                        fieldWithPath("result").type(JsonFieldType.STRING).description("ResultType"),
//                        fieldWithPath("data").type(JsonFieldType.OBJECT).ignored(),
//                        fieldWithPath("error").type(JsonFieldType.STRING).ignored(),
//                    ),
//                ),
//            )
    }
}
