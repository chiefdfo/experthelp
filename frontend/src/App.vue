<template>
    <v-app class="hackathon">
        <v-app-bar app color="tertiary" prominent elevate-on-scroll>
            <v-container fill-height class="d-flex align-center justify-space-between">
                <h2 class="primary">LOGO HIERHIN</h2>
                <div class="d-flex">
                    <v-btn text x-large class="mr-2">
                        Anmelden
                    </v-btn>
                    <v-btn color="secondary" depressed x-large>
                        Registrieren
                    </v-btn>
                </div>
            </v-container>
        </v-app-bar>
        <v-content>
            <router-view />
        </v-content>
        <v-footer>
            <v-container>
                <v-row>
                    <v-col cols="12" md="3" class="footer__col -rightBorder d-flex align-center row">
                        <h1>Logo</h1>
                        <p>Eine Initiative von <b>#wirvsvirus</b></p>
                    </v-col>
                    <v-col cols="12" md="2">
                        <p class="mb-3"><b>Projektname</b></p>
                        <p class="mb-2">Über</p>
                        <p class="mb-2">Team</p>
                        <p class="mb-2">Kontakt</p>
                    </v-col>
                    <v-col cols="12" md="2">
                        <p class="mb-3"><b>Unterstützer</b></p>
                        <p class="mb-2">Als Unternehmen</p>
                        <p class="mb-2">Als Fachkraft</p>
                        <p class="mb-2">Erfolgsgeschichte</p>
                    </v-col>
                    <v-col cols="12" md="2">
                        <p class="mb-3"><b>Weitere Informationen</b></p>
                        <p class="mb-2">FAQ</p>
                        <p class="mb-2">Impressum</p>
                        <p class="mb-2">Datenschutz</p>
                    </v-col>
                    <v-col cols="12" md="3" class="text-center">
                        <p class="mb-3"><b>Folge uns auf:</b></p>
                        <v-btn icon>
                            <v-icon>mdi-facebook</v-icon>
                        </v-btn>
                        <v-btn icon>
                            <v-icon>mdi-instagram</v-icon>
                        </v-btn>
                        <v-btn icon>
                            <v-icon>mdi-twitter</v-icon>
                        </v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-footer>
    </v-app>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { routeNames } from '@/constants/routeNames';

@Component({
    name: routeNames.APP,
    components: {},
})
export default class extends Vue {}
</script>

<style lang="scss">
@import '../src/scss/variable';
@import '../src/scss/globals';
.footer {
    &__col {
        position: relative;
        &.-rightBorder {
            &::after {
                position: absolute;
                content: '';
                width: 1px;
                height: 115px;
                top: 15px;
                right: 30px;
                background-color: $secondary;
            }
        }
    }
}
</style>
