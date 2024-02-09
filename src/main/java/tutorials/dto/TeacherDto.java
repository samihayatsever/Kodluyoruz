package com.samih.kodluyoruzspringboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDto {

    private Long teacherId;

    @NotEmpty(message = "Ad soyad alanını boş geçemezsiniz")
    @Size(min = 1, max = 50)
    private String teacherNameSurname;

    @NotEmpty(message = "Email alanını boş geçemezsiniz")
    @Email(message = "Uygun formatta bir mail adresi giriniz")
    private String teacherEmail;

    @NotEmpty(message = "Şifre alanını boş geçemezsiniz")
    //@Min(value = 18, message = "En az 18 yaşında olmanız gerekiyor.")
    //@Max(value = 50, message = "En fazla 50 yaşında olmanız gerekiyor.")
    @Size(min = 8, max = 14)
    private String teacherPassword;
}
