package com.umbertoemonds.docharmonie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umbertoemonds.docharmonie.model.dto.in.LoginDTOIn;
import com.umbertoemonds.docharmonie.repository.AccordRepository;
import com.umbertoemonds.docharmonie.repository.GrilleRepository;
import com.umbertoemonds.docharmonie.repository.UtilisateurRepository;
import com.umbertoemonds.docharmonie.service.GrilleService;
import com.umbertoemonds.docharmonie.service.UtilisateurService;
import com.umbertoemonds.docharmonie.utils.SecurityConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
public abstract class AbstractWebTest {
    
    @MockBean
    protected MockMvc mockMvc;

    @Autowired
    protected UtilisateurService utilisateurService;

    @Autowired
    protected GrilleService grilleService;

    @Autowired
    protected AccordRepository accordRepository;

    @Autowired
    protected GrilleRepository grilleRepository;

    @Autowired
    protected UtilisateurRepository utilisateurRepository;

    protected ResultActions login() throws Exception {
        var loginDTO = new LoginDTOIn("umberto.emonds@gmail.com", "admin");
        var mapper = new ObjectMapper();

        var result = mockMvc.perform(MockMvcRequestBuilders.get(SecurityConstants.SIGN_IN_URL)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(loginDTO)));

        result.andExpect(MockMvcResultMatchers.status().isOk());

        return result;
    }

    protected String getJWT(ResultActions result) {
		return result.andReturn().getResponse().getHeader(SecurityConstants.TOKEN_HEADER);
	}

}
